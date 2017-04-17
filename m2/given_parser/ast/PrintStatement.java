package ast;

import java.util.Hashtable;
import java.util.List;

public class PrintStatement
   extends AbstractStatement
{
   private final Expression expression;

   public PrintStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }
  
   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType) { 
      if (!(expression.checkType(funcTable, structTable, retType) instanceof IntType)) {
         throw new IllegalArgumentException("print requires an integer argument");
      }
   }

   public boolean checkReturn(Type retType) {
      return false;
   }

   public void buildBlock(List<Block> allBlockList) {
      Block b = new Block(allBlockList.size());
      allBlockList.add(b);
   }
}
