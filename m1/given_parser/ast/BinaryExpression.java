package ast;

import java.util.Hashtable;

public class BinaryExpression
   extends AbstractExpression
{
   private final Operator operator;
   private final Expression left;
   private final Expression right;

   private BinaryExpression(int lineNum, Operator operator,
      Expression left, Expression right)
   {
      super(lineNum);
      this.operator = operator;
      this.left = left;
      this.right = right;
   }

   public static BinaryExpression create(int lineNum, String opStr,
      Expression left, Expression right)
   {
      switch (opStr)
      {
         case TIMES_OPERATOR:
            return new BinaryExpression(lineNum, Operator.TIMES, left, right);
         case DIVIDE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.DIVIDE, left, right);
         case PLUS_OPERATOR:
            return new BinaryExpression(lineNum, Operator.PLUS, left, right);
         case MINUS_OPERATOR:
            return new BinaryExpression(lineNum, Operator.MINUS, left, right);
         case LT_OPERATOR:
            return new BinaryExpression(lineNum, Operator.LT, left, right);
         case LE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.LE, left, right);
         case GT_OPERATOR:
            return new BinaryExpression(lineNum, Operator.GT, left, right);
         case GE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.GE, left, right);
         case EQ_OPERATOR:
            return new BinaryExpression(lineNum, Operator.EQ, left, right);
         case NE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.NE, left, right);
         case AND_OPERATOR:
            return new BinaryExpression(lineNum, Operator.AND, left, right);
         case OR_OPERATOR:
            return new BinaryExpression(lineNum, Operator.OR, left, right);
         default:
            throw new IllegalArgumentException();
      }
   }

   /*public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      return new IntType();
   }*/

   public Type checkType(Hashtable<String,Type> funcTable,
	Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      System.out.println("Checking BinaryExpression");
      if (this.operator == Operator.TIMES || this.operator == Operator.DIVIDE
	|| this.operator == Operator.PLUS || this.operator == Operator.MINUS) {
         if (left.checkType(funcTable, structTable, retType) instanceof IntType && right.checkType(funcTable, structTable, retType) instanceof IntType) {
            return new IntType();
         }   
         else {
            throw new IllegalArgumentException("Left and right expressions should be of type int");
         }   
      } 
      else if (this.operator == Operator.LT || this.operator == Operator.GT
	|| this.operator == Operator.LE || this.operator == Operator.GE) {
         if (left.checkType(funcTable, structTable, retType) instanceof IntType && right.checkType(funcTable, structTable, retType) instanceof IntType) {
            return new BoolType();
         }   
         else {
            throw new IllegalArgumentException("Left and right expressions should be of type int");
         }   
      }   
      else if (this.operator == Operator.EQ || this.operator == Operator.NE) {
         if (left.checkType(funcTable, structTable, retType) instanceof IntType && right.checkType(funcTable, structTable, retType) instanceof IntType) {
            return new IntType();
         }
         else if (left.checkType(funcTable, structTable, retType) instanceof BoolType && right.checkType(funcTable, structTable, retType) instanceof BoolType) {
            return new BoolType();
         }
         else {
            throw new IllegalArgumentException("Left and right expressions should be of same type");
         }   
      }
      else if (this.operator == Operator.AND || this.operator == Operator.OR) {
         if (left.checkType(funcTable, structTable, retType) instanceof BoolType && right.checkType(funcTable, structTable, retType) instanceof BoolType) {
            return new BoolType();
         }
         else {
            throw new IllegalArgumentException("Left and right expressions should be of type bool");
         }   
      }
      throw new IllegalArgumentException("Invalid operator");
   }


   private static final String TIMES_OPERATOR = "*";
   private static final String DIVIDE_OPERATOR = "/";
   private static final String PLUS_OPERATOR = "+";
   private static final String MINUS_OPERATOR = "-";
   private static final String LT_OPERATOR = "<";
   private static final String LE_OPERATOR = "<=";
   private static final String GT_OPERATOR = ">";
   private static final String GE_OPERATOR = ">=";
   private static final String EQ_OPERATOR = "==";
   private static final String NE_OPERATOR = "!=";
   private static final String AND_OPERATOR = "&&";
   private static final String OR_OPERATOR = "||";

   public static enum Operator
   {
      TIMES, DIVIDE, PLUS, MINUS, LT, GT, LE, GE, EQ, NE, AND, OR
   }
}
