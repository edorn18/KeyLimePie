package ast;

import java.util.Hashtable;

public class PrintStatement
   extends AbstractStatement
{
   private final Expression expression;

   public PrintStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }
  
   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable) { 
      if (expression.checkType(funcTable, structTable) instanceof IntType) {
         return new IntType();
      }
      throw new IllegalArgumentException("print requires an integer argument");
   }
}
