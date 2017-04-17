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
      body.checkType((this.funcTable).get(name), this.structTable, retType);
      if (body.checkReturn(retType) == false) {
         throw new IllegalArgumentException("Function " + name + " does not return correctly");
      }
   }

   public void buildCFG(List<Block> allBlockList) {
      body.buildBlock(allBlockList);   
   }

}
