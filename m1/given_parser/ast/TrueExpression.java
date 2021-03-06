package ast;

import java.util.Hashtable;

public class TrueExpression
   extends AbstractExpression
{
   public TrueExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
//      System.out.println("Checking TrueExpression");
      return new BoolType();
   } 
}
