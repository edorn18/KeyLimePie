package ast;

import java.util.Hashtable;

public class ReadExpression
   extends AbstractExpression
{
   public ReadExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
//      System.out.println("Checking ReadExpression");
      return new IntType();
   }  
}
