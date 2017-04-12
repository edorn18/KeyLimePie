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
      FuncType f;
      List<Declaration> params;
      Type funcReturnType;

      if (funcTable.get(name) == null) {
         throw new IllegalArgumentException("Call to function does not exist");
      }
      else {
         f = (FuncType) funcTable.get(name);
         params = f.getFuncParams();
         funcReturnType = f.getFuncType();
         if (params.size() != arguments.size()) {
            throw new IllegalArgumentException("Amount of parameters and arguments not the same");
         }
         for (int i = 0; i < params.size(); i++) {
            if (params.get(i).getDeclType().getClass() != arguments.get(i).checkType(funcTable, structTable, retType).getClass()) {
               throw new IllegalArgumentException("Argument and parameter type do not match");
            }
         }
         return funcReturnType;
      }
   } 
}
