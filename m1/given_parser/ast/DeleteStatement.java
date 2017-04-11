package ast;

import java.util.Hashtable;

public class DeleteStatement
   extends AbstractStatement
{
   private final Expression expression;

   public DeleteStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable) {
      if (expression.checkType(funcTable, structTable) instanceof StructType) {
         return new NullType();
      }
      throw new IllegalArgumentException("Expression must be a struct");
   }
}
