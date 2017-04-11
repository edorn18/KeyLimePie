package ast;

import java.util.Hashtable;

public class LvalueId
   implements Lvalue
{
   private final int lineNum;
   private final String id;

   public LvalueId(int lineNum, String id)
   {
      this.lineNum = lineNum;
      this.id = id;
   }
  
   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable) { 
      return new IntType();
   }
}
