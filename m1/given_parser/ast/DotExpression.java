package ast;

import java.util.Hashtable;

public class DotExpression
   extends AbstractExpression
{
   private final Expression left;
   private final String id;

   public DotExpression(int lineNum, Expression left, String id)
   {
      super(lineNum);
      this.left = left;
      this.id = id;
   }
 
   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable) { 
      return new IntType();
   }
}
