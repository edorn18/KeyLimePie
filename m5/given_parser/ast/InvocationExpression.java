package ast;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;

public class InvocationExpression
   extends AbstractExpression
{
   private final String name;
   private final List<Expression> arguments;

   public InvocationExpression(int lineNum, String name,
      List<Expression> arguments)
   {
      super(lineNum);
      this.name = name;
      this.arguments = arguments;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      FuncType f;
      List<Declaration> params;
      Type funcReturnType;

//      System.out.println("Checking InvocationExpression");
      if (funcTable.get(name) == null) {
         throw new IllegalArgumentException("Call to function does not exist");
      }
      else {
         f = (FuncType) funcTable.get(name);
         params = f.getFuncParams();
         funcReturnType = f.getFuncType();
         if (params.size() != arguments.size()) {
            throw new IllegalArgumentException("Line #: " + lineNum + "- Amount of parameters and arguments not the same");
         }
         for (int i = 0; i < params.size(); i++) {
            if (params.get(i).getDeclType().getClass() != arguments.get(i).checkType(funcTable, structTable, retType).getClass()) {
               if (!(params.get(i).getDeclType() instanceof StructType && arguments.get(i).checkType(funcTable, structTable, retType) instanceof NullType)) {
               throw new IllegalArgumentException("Line #: " + lineNum + "- Argument and parameter type do not match");
               }
            }
         }
         return funcReturnType;
      }
   }

   public Value buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      List<Value> regList = new ArrayList<Value>();
      String returnString = "";
      Value v;
      Register r;

      for (int i = 0; i < arguments.size(); i++) {
         v = arguments.get(i).buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         regList.add(v);
      }

      FuncType f = (FuncType)(globalTable.get(name));


      if (f.getFuncType() instanceof VoidType) {
         r = new Register(new iType(64));
         returnString = "void";
         curBlock.addInstruction(new FuncVoidInvocationInstruction(name, regList, returnString));
      }
      else if (f.getFuncType() instanceof StructType) {
         r = new Register((new LLVMStructType(((StructType)(f.getFuncType())).getStructName())));
         returnString = r.getRegType().getLLVMTypeName();
         curBlock.addInstruction(new FuncInvocationInstruction(name, regList, returnString, r));
      }
      else {
         r = new Register(new iType(64));
         returnString = r.getRegType().getLLVMTypeName();
         curBlock.addInstruction(new FuncInvocationInstruction(name, regList, returnString, r));
      }

      return r;
   } 
}
