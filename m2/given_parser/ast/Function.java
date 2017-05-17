package ast;

import java.util.List;
import java.util.Hashtable;

public class Function
{
   private final int lineNum;
   private final String name;
   private final Type retType;
   private final List<Declaration> params;
   private final List<Declaration> locals;
   private final Statement body;
   private Hashtable<String, Hashtable<String,Type>> funcTable;
   private Hashtable<String, Hashtable<String,Type>> structTable;   
   private Hashtable<String, Type> globalTable;
   private Hashtable<String, Type> localTable;
   private Hashtable<String, String> varTable;

   public Function(int lineNum, String name, List<Declaration> params,
      Type retType, List<Declaration> locals, Statement body)
   {
      this.lineNum = lineNum;
      this.name = name;
      this.params = params;
      this.retType = retType;
      this.locals = locals;
      this.body = body;
   }

   public String getFunctionName() {
      return name;
   }

   public Type getFunctionRetType() {
      return retType;
   }

   public List<Declaration> getFunctionParams() {
      return params;
   }
   
   public List<Declaration> getFunctionLocals() {
      return locals;
   }

   public void checkType(Hashtable<String, Hashtable<String,Type>> funcTable, Hashtable<String, Hashtable<String,Type>> structTable) {
      this.funcTable = funcTable;
      this.structTable = structTable;
      if (((BlockStatement)body).isEmpty()) {
         if (!(retType instanceof VoidType)) {
            throw new IllegalArgumentException("Function " + name + " does not return correctly");
         }
      }
      else {
         body.checkType((this.funcTable).get(name), this.structTable, retType);
         if (body.checkReturn(retType) == false) {
            throw new IllegalArgumentException("Function " + name + " does not return correctly");
         }
      }
   }

   private void makeLocalTable() {
      localTable = new Hashtable<String,Type>();
      varTable = new Hashtable<String,String>();
      for (int j = 0; j < params.size(); j++) {
            localTable.put(params.get(j).getDeclName(), params.get(j).getDeclType());
            varTable.put(params.get(j).getDeclName(), "_P_" + params.get(j).getDeclName());
      }
      for (int j = 0; j < locals.size(); j++) {
            localTable.put(locals.get(j).getDeclName(), locals.get(j).getDeclType());
            varTable.put(locals.get(j).getDeclName(), locals.get(j).getDeclName());
      }
   }

   public void buildCFG(List<Block> allBlockList, List<Block> startBlockList, List<Block> endBlockList, Hashtable<String,Type> gTable) {
      this.globalTable = gTable;
      makeLocalTable();
      Block temp;
      Block start = new Block(allBlockList.size());
      allBlockList.add(start);
      startBlockList.add(start);
      buildLLVMFuncStart(start);
      Block end = new Block(allBlockList.size());
      allBlockList.add(end);
      endBlockList.add(end);
      if (((BlockStatement)body).isEmpty()) {
         start.addBlock(end);
      }
      else {
         temp = body.buildBlock(allBlockList, start, end, globalTable, localTable, varTable);
         if (temp != end) {
            temp.addBlock(end);
            temp.addInstruction(new BranchLabelInstruction(end));
         } 
      }
      if (retType instanceof VoidType) {
         end.addInstruction(new ReturnVoidInstruction());
      }
      else if (retType instanceof StructType) {
         LoadInstruction l = new LoadInstruction(new LLVMStructType(((StructType)retType).getStructName()), "_retval_");
         end.addInstruction(l);
         end.addInstruction(new ReturnInstruction(l.getReg()));
      }
      else {
         LoadInstruction l = new LoadInstruction(new iType(64), "_retval_");
         end.addInstruction(l);
         end.addInstruction(new ReturnInstruction(l.getReg()));
      }
   }

   public void buildLLVMFuncStart(Block start) {
      if (!(retType instanceof VoidType)) {
         if (retType instanceof StructType) {
            start.addInstruction(new FuncReturnInstruction(new LLVMStructType(((StructType)retType).getStructName())));
         }
         else {
            start.addInstruction(new FuncReturnInstruction(new iType(64)));
         }
      }
      for (int i = 0; i < params.size(); i++) {
         if (params.get(i).getDeclType() instanceof StructType) {
            start.addInstruction(new FuncParamInstruction(params.get(i).getDeclName(), new LLVMStructType(((StructType)(params.get(i).getDeclType())).getStructName())));
         }
         else {
            start.addInstruction(new FuncParamInstruction(params.get(i).getDeclName(), new iType(64)));
         }
      }
      for (int i = 0; i < locals.size(); i++) {
         if (locals.get(i).getDeclType() instanceof StructType) {
            start.addInstruction(new FuncLocalInstruction(locals.get(i).getDeclName(), new LLVMStructType(((StructType)(locals.get(i).getDeclType())).getStructName())));
         }
         else {
            start.addInstruction(new FuncLocalInstruction(locals.get(i).getDeclName(), new iType(64)));
         }
      }
      for (int i = 0; i < params.size(); i++) {
         if (params.get(i).getDeclType() instanceof StructType) {
            LLVMType temp_type = new LLVMStructType(((StructType)(params.get(i).getDeclType())).getStructName());
            Value v1 = new Register(temp_type, params.get(i).getDeclName());
            Value v2 = new Register(temp_type, "_P_" + params.get(i).getDeclName());
            start.addInstruction(new StoreInstruction(temp_type, v1, temp_type, v2));
         }
         else {
            LLVMType temp_type = new iType(64);
            Value v1 = new Register(temp_type, params.get(i).getDeclName());
            Value v2 = new Register(temp_type, "_P_" + params.get(i).getDeclName());
            start.addInstruction(new StoreInstruction(temp_type, v1, temp_type, v2));
         }
      }



   }

}
