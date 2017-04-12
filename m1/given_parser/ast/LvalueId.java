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
 
   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) { 
      if (funcTable.get(id) == null) {
         throw new IllegalArgumentException("Id " + id  + " does not exist.");
      }
      return funcTable.get(id);