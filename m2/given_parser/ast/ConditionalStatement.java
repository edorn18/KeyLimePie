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

   public void buildBlock(List<Block> allBlockList) {

   }
}
