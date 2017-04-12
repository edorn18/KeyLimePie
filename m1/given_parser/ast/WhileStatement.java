package ast;

import java.util.Hashtable;

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
  
   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) { 
      if (!(guard.checkType(funcTable, structTable, retType) instanceof BoolType)) {
         throw new IllegalArgumentException("Guard does not evaluate to bool type");
      }
      body.checkType(funcTable, structTable, retType);
   }

}
