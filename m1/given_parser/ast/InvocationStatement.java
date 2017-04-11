package ast;

import java.util.List;
import java.util.Hashtable;

public class InvocationStatement
   extends AbstractStatement
{
   private final Expression expression;

   public InvocationStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable) {
      return new IntType();
   }
}
