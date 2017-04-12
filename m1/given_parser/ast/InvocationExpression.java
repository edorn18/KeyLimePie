package ast;

import java.util.Hashtable;

import java.util.List;

public class InvocationExpression
   extends AbstractExpression
{
   private final String name;
   private final List<Expression> arguments;

   public InvocationExpression(int lineNum, String name,
      List<Expression> arguments)
   {
      super(lineNum);
      this.name = name;
      this.arguments = arguments;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      return new IntType();
   } 
}
