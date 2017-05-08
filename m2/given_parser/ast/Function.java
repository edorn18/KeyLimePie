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
      for (int j = 0; j < params.size(); j++) {
            localTable.put(params.get(j).getDeclName(), params.get(j).getDeclType());
      }
      for (int j = 0; j < locals.size(); j++) {
            localTable.put(locals.get(j).getDeclName(), locals.get(j).getDeclType());
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
         temp = body.buildBlock(allBlockList, start, end, globalTable, localTable);
         if (temp != end) {
            temp.addBlock(end);
         } 
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
   }

}
