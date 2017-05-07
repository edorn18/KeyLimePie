package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;

public class BlockStatement
   extends AbstractStatement
{
   private final List<Statement> statements;

   public BlockStatement(int lineNum, List<Statement> statements)
   {
      super(lineNum);
      this.statements = statements;
   }

   public static BlockStatement emptyBlock()
   {
      return new BlockStatement(-1, new ArrayList<>());
   }

   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      for (int i = 0; i < statements.size(); i++) {
         statements.get(i).checkType(funcTable, structTable, retType);
      }
   }

   public boolean checkReturn(Type retType) {
      if (retType instanceof VoidType) {
         return true;
      }
      for (int i = 0; i < statements.size(); i++) {
         if (statements.get(i).checkReturn(retType)) {
            return true;
         }
      }
      return false;
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock) {
      for (int i = 0; i < statements.size(); i++) {
         curBlock = statements.get(i).buildBlock(allBlockList, curBlock, endBlock);
      }
      return curBlock;
   }

   public boolean isEmpty() {
      if (statements.size() == 0) {
         return true;
      }
      else {
         return false;
      }
   }
}
