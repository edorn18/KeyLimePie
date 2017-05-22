package ast;

import java.util.Hashtable;
import java.util.List;

public class ReturnStatement
   extends AbstractStatement
{
   private final Expression expression;

   public ReturnStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (!(expression.checkType(funcTable, structTable, retType).getClass().equals(retType.getClass()))) {
         throw new IllegalArgumentException("Line #: " + lineNum + "- Expression does not match return type of function");
      } 
   }

   public boolean checkReturn(Type retType) {
      return true;   
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      
      Value v = expression.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
      curBlock.addInstruction(new StoreInstruction(v.getRegType(), v, v.getRegType(), new Register(v.getRegType(), "_retval_")));
      curBlock.addInstruction(new BranchLabelInstruction(endBlock));
      curBlock.addBlock(endBlock);

      return endBlock;
   }
}
