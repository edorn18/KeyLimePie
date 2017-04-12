package ast;

import java.util.Hashtable;

public class PrintLnStatement
   extends AbstractStatement
{
   private final Expression expression;

   public PrintLnStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (!(expression.checkType(funcTable, structTable, retType) instanceof IntType)) {
         throw new IllegalArgumentException("println requires an integer argument");
      }
   }
}
