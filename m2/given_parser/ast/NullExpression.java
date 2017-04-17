package ast;

import java.util.Hashtable;

public class NullExpression
   extends AbstractExpression
{
   public NullExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
//      System.out.println("Checking NullExpression");
      return new NullType();
   } 
}
