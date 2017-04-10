package ast;

public class WhileStatement
   extends AbstractStatement
{
   private final Expression guard;
   private final Statement body;

   public WhileStatement(int lineNum, Expression guard, Statement body)
   {
      super(lineNum);
      this.guard = guard;
      this.body = body;
   }
   
   public Type checkType() {
      if (guard.checkType() instanceof BoolType) {
         return new BoolType();
      }
      throw new IllegalArgumentException("Guard does not evaluate to bool type");
   }

}
