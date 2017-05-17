package ast;

import java.util.Hashtable;
import java.util.List;

public class ReturnEmptyStatement
   extends AbstractStatement
{
   public ReturnEmptyStatement(int lineNum)
   {
      super(lineNum);
   }

   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType) { 
      if (!(retType instanceof VoidType)) {
         throw new IllegalArgumentException("Line #: " + lineNum + "- Function return type is not void");
      } 
   }

   public boolean checkReturn(Type retType) {
      return true;
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable) {
      curBlock.addBlock(endBlock);
      curBlock.addInstruction(new BranchLabelInstruction(endBlock));
      return endBlock;
   }
}
