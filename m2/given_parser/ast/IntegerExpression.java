package ast;

import java.util.Hashtable;

public class IntegerExpression
   extends AbstractExpression
{
   private final String value;

   public IntegerExpression(int lineNum, String value)
   {
      super(lineNum);
      this.value = value;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
    //  System.out.println("Checking UnaryExpression");
      return new IntType();
   } 
}
