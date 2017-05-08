package ast;

import java.util.Hashtable;
import java.util.List;

public class FalseExpression
   extends AbstractExpression
{
   public FalseExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
    //  System.out.println("Checking FalseExpression");
      return new BoolType();
   }

   public Register buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable) {
      return null;
   }
}
