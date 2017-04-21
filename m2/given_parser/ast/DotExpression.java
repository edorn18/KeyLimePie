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

    //  System.out.println("Checking DotExpression");
      if (left.checkType(funcTable, structTable, retType) instanceof StructType)
       {
         struct = structTable.get(((StructType)(left.checkType(funcTable, structTable, retType))).getStructName());
         if (struct.get(id) == null) {
            throw new IllegalArgumentException("Line #: " + lineNum + "- Id does not exist in struct");
         }
         //System.out.println("This is the struct table");
         //System.out.println(struct);
         //System.out.println("This is the id: " + id);
         //System.out.println("This is id type from the struct: " + struct.get(id).getClass().getName());
         return struct.get(id);
      }
      System.out.println("This is left type: " + left.checkType(funcTable, structTable, retType).getClass());
      throw new IllegalArgumentException("Line #: " + lineNum + "- DotExpression left is not a struct");
   }
}
