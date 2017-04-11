package ast;

import java.util.Hashtable;

public class NewExpression
   extends AbstractExpression
{
   private final String id;

   public NewExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }
 
   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable) { 
      return new StructType(lineNum, id);
   }
}
