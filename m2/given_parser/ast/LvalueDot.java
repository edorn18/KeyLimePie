package ast;

import java.util.Hashtable;

public class LvalueDot
   implements Lvalue
{
   private final int lineNum;
   private final Expression left;
   private final String id;

   public LvalueDot(int lineNum, Expression left, String id)
   {
      this.lineNum = lineNum;
      this.left = left;
      this.id = id;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (left.checkType(funcTable, structTable, retType) instanceof StructType) {
         if (structTable.get(((StructType)left).getStructName()).get(id) == null) {
            throw new IllegalArgumentException("Id field '" + id  + "' does not exist in struct.");
         }      
      }
      else {
         throw new IllegalArgumentException("Left Expression must be of type struct.");
      }

      return structTable.get(((StructType)left).getStructName()).get(id);
   }
}
