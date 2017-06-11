package ast;

import java.util.Hashtable;
import java.util.List;

public class UnaryExpression
   extends AbstractExpression
{
   private final Operator operator;
   private final Expression operand;

   private UnaryExpression(int lineNum, Operator operator, Expression operand)
   {
      super(lineNum);
      this.operator = operator;
      this.operand = operand;
   }

   public static UnaryExpression create(int lineNum, String opStr,
      Expression operand)
   {
      if (opStr.equals(NOT_OPERATOR))
      {
         return new UnaryExpression(lineNum, Operator.NOT, operand);
      }
      else if (opStr.equals(MINUS_OPERATOR))
      {
         return new UnaryExpression(lineNum, Operator.MINUS, operand);
      }
      else
      {
         throw new IllegalArgumentException();
      }
   }

/*   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      return new IntType();
   }*/


   public Type checkType(Hashtable<String,Type> funcTable,
	Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
//      System.out.println("Checking UnaryExpression");
      if (this.operator == Operator.NOT) {
         if (operand.checkType(funcTable, structTable, retType) instanceof BoolType) {
            return new BoolType();
         }
         else {
            throw new IllegalArgumentException("Operand should evaluate to bool type");
         }
      }
      else if (this.operator == Operator.MINUS) {
         if (operand.checkType(funcTable, structTable, retType) instanceof IntType) {
            return new IntType();
         }
         else {
            throw new IllegalArgumentException("Operand does should evaluate to int type");
         }
      }
      throw new IllegalArgumentException("Invalid operator");
   }

   public Value buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      Value v1 = operand.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
      if (this.operator == Operator.MINUS) { 
         return new ImmediateRegister("-" + v1.getRegName());
      }
      else {
         XorInstruction instr = new XorInstruction(v1, new ImmediateRegister("1"));
         curBlock.addInstruction(instr);
         Value v2 = instr.getReg();
         return v2;
      }
   }

   private static final String NOT_OPERATOR = "!";
   private static final String MINUS_OPERATOR = "-";

   public static enum Operator
   {
      NOT, MINUS
   }
}
