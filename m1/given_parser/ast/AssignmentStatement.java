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
/*
      if (target.checkType(funcTable, structTable) instanceof IntType) {
         if (source.checkType(funcTable, structTable) instanceof IntType) {
            return new IntType();
         }
         else {
            throw new IllegalArgumentException("Left and right hand side must be of same type.");
         }
      }
      else if (target.checkType(funcTable, structTable) instanceof BoolType) {
         if (source.checkType(funcTable, structTable) instanceof BoolType) {
            return new BoolType();
         }
         else {
            throw new IllegalArgumentException("Left and right hand side must be of same type.");
         }
      }
      else if (target.checkType(funcTable, structTable) instanceof StructType) {
         if (source.checkType(funcTable, structTable) instanceof StructType ||
	  source.checkType(funcTable, structTable) instanceof NullType) {
//            return new StructType(lineNum, );
            return new IntType();
         }
         else {
            throw new IllegalArgumentException("Left and right hand side must be of same type.");
         }
      }
      throw new IllegalArgumentException("Left hand side has invalid type.");
      */

   }

}
