package ast;

import java.util.Hashtable;

public class ReturnStatement
   extends AbstractStatement
{
   private final Expression expression;

   public ReturnStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (!(expression.checkType(funcTable, structTable, retType).getClass().equals(retType.getClass()))) {
         throw new IllegalArgumentException("Expression does not match return type of function");
      } 
   }
}
