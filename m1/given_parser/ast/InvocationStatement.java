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

   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      expression.checkType(funcTable, structTable, retType);
   }

   public boolean checkReturn(Type retType) {
      return false;
   }
}
