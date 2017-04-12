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
 
   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      Hashtable<String, Type> struct;

      if (left.checkType(funcTable, structTable, retType) instanceof StructType)
       {
         struct = structTable.get(((StructType)left.checkType(funcTable, structTable, retType)).getStructName());
         if (struct.get(id) == null) {
            throw new IllegalArgumentException("Id does not exist in struct");
         }
         return struct.get(id);
      }
      throw new IllegalArgumentException("DotExpression left is not a struct");
   }
}
