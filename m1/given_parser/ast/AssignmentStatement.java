package ast;

import java.util.Hashtable;

public class AssignmentStatement
   extends AbstractStatement
{
   private final Lvalue target;
   private final Expression source;

   public AssignmentStatement(int lineNum, Lvalue target, Expression source)
   {
      super(lineNum);
      this.target = target;
      this.source = source;
   }

   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {

      if (target.checkType(funcTable, structTable, retType) instanceof IntType) {
         if (!(source.checkType(funcTable, structTable, retType) instanceof IntType)) {
            throw new IllegalArgumentException("Left and right hand side must be of same type.");
         }
      }
      else if (target.checkType(funcTable, structTable, retType) instanceof BoolType) {
         if (!(source.checkType(funcTable, structTable, retType) instanceof BoolType)) {
            throw new IllegalArgumentException("Left and right hand side must be of same type.");
         }
      }
      else if (target.checkType(funcTable, structTable, retType) instanceof StructType) {
         if (!(source.checkType(funcTable, structTable, retType) instanceof StructType) ||
	  !(source.checkType(funcTable, structTable, retType) instanceof NullType)) {
            throw new IllegalArgumentException("Left and right hand side must be of same type.");
         }
      }
      throw new IllegalArgumentException("Left hand side has invalid type.");
   }

}
