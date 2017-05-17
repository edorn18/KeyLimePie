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

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable) {
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

      Value v = guard.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable);
      curBlock.addInstruction(new BranchCondInstruction(v, newThenBlock, newElseBlock));      
      tempThenBlock = thenBlock.buildBlock(allBlockList, newThenBlock, endBlock, globalTable, localTable, varTable);
      tempElseBlock = elseBlock.buildBlock(allBlockList, newElseBlock, endBlock, globalTable, localTable, varTable);

      if (tempThenBlock == endBlock && tempElseBlock == endBlock) {
         return endBlock;
      }
      else {
         newJoinBlock = new Block(allBlockList.size());
         
         if (tempThenBlock != endBlock) {
            tempThenBlock.addInstruction(new BranchLabelInstruction(newJoinBlock));
         }
         if (tempElseBlock != endBlock) {
            tempElseBlock.addInstruction(new BranchLabelInstruction(newJoinBlock));
         }

         if (tempThenBlock != endBlock) {
            tempThenBlock.addBlock(newJoinBlock);
         }
         if (tempElseBlock != endBlock) {
            tempElseBlock.addBlock(newJoinBlock);
         }

         allBlockList.add(newJoinBlock);

         return newJoinBlock;
      }
   }
}
