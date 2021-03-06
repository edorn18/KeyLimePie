package ast;

import java.util.Hashtable;

public class ReturnEmptyStatement
   extends AbstractStatement
{
   public ReturnEmptyStatement(int lineNum)
   {
      super(lineNum);
   }

   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType) { 
      if (!(retType instanceof NullType)) {
         throw new IllegalArgumentException("Line #: " + lineNum + "- Function return type is not void");
      } 
   }

   public boolean checkReturn(Type retType) {
      return true;
   }
}
