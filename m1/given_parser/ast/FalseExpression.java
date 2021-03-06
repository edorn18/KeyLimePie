package ast;

import java.util.Hashtable;

public class FalseExpression
   extends AbstractExpression
{
   public FalseExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
    //  System.out.println("Checking FalseExpression");
      return new BoolType();
   }
}
