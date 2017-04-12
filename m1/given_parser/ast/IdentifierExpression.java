package ast;

import java.util.Hashtable;

public class IdentifierExpression
   extends AbstractExpression
{
   private final String id;

   public IdentifierExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
/*      if (funcTable) {
         return new NullType();
      }
      throw new IllegalArgumentException("Id was not found");
*/
      return new IntType();
   }
}
