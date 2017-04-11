package ast;

import java.util.Hashtable;

public class ReturnEmptyStatement
   extends AbstractStatement
{
   public ReturnEmptyStatement(int lineNum)
   {
      super(lineNum);
   }
  
   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable) { 
      return new IntType();
   }
}
