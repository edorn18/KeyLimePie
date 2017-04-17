package ast;

import java.util.Hashtable;
import java.util.List;

public class ConditionalStatement
   extends AbstractStatement
{
   private final Expression guard;
   private final Statement thenBlock;
   private final Statement elseBlock;

   public ConditionalStatement(int lineNum, Expression guard,
      Statement thenBlock, Statement elseBlock)
   {
      super(lineNum);
      this.guard = guard;
      this.thenBlock = thenBlock;
      this.elseBlock = elseBlock;
   }

   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (!(guard.checkType(funcTable, structTable, retType) instanceof BoolType)) {
         throw new IllegalArgumentException("Line #: " + lineNum + "- Conditional guard must be boolean");
      }
      thenBlock.checkType(funcTable, structTable, retType);
      elseBlock.checkType(funcTable, structTable, retType);
   }

   public boolean checkReturn(Type retType) {
      if (thenBlock.checkReturn(retType) && elseBlock.checkReturn(retType)) {
         return true;
      }
      return false;
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock) {
      Block newThenBlock;
      Block newElseBlock;
      Block newJoinBlock;
      Block tempThenBlock;
      Block tempElseBlock;

      newThenBlock = new Block(allBlockList.size());
      allBlockList.add(newThenBlock);
      newElseBlock = new Block(allBlockList.size());
      allBlockList.add(newElseBlock);

      curBlock.addBlock(newThenBlock);
      curBlock.addBlock(newElseBlock);

      tempThenBlock = thenBlock.buildBlock(allBlockList, newThenBlock, endBlock);
      tempElseBlock = elseBlock.buildBlock(allBlockList, newElseBlock, endBlock);

      newJoinBlock = new Block(allBlockList.size());
     
      tempThenBlock.addBlock(newJoinBlock);
      tempElseBlock.addBlock(newJoinBlock);

      allBlockList.add(newJoinBlock);

      return newJoinBlock;
   }
}