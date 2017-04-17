package ast;

import java.util.Hashtable;
import java.util.List;

public class DeleteStatement
   extends AbstractStatement
{
   private final Expression expression;

   public DeleteStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (!(expression.checkType(funcTable, structTable, retType) instanceof StructType || expression.checkType(funcTable, structTable, retType) instanceof NullType)) {
         throw new IllegalArgumentException("Delete expression must be a struct or null");
      }
   }

   public boolean checkReturn(Type retType) {
      return false;
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock) {
      return curBlock;
   }
}
