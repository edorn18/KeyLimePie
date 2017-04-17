package ast;

import java.util.List;

public class FuncType
   implements Type
{
   private final List<Declaration> params;
   private final Type retType;

   public FuncType(List<Declaration> params, Type retType)
   {
      this.params = params;
      this.retType = retType;
   }

   public List<Declaration> getFuncParams() {
      return params;
   }

   public Type getFuncType() {
      return retType;
   }
}
