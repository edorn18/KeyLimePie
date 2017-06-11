package ast;

import java.util.Hashtable;
import java.util.List;

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
            throw new IllegalArgumentException("Line #: " + lineNum + "- Left and right expressions should be of type int");
         }   
      }   
      else if (this.operator == Operator.EQ || this.operator == Operator.NE) {
         if (left.checkType(funcTable, structTable, retType) instanceof IntType && right.checkType(funcTable, structTable, retType) instanceof IntType) {
            return new BoolType();
         }
         else if (left.checkType(funcTable, structTable, retType) instanceof BoolType && right.checkType(funcTable, structTable, retType) instanceof BoolType) {
            return new BoolType();
         }
         else if (left.checkType(funcTable, structTable, retType) instanceof StructType && (right.checkType(funcTable, structTable, retType) instanceof StructType || right.checkType(funcTable, structTable, retType) instanceof NullType)) {
            return new BoolType();
         }
         else {
            throw new IllegalArgumentException("Line #: " + lineNum + "Left and right expressions should be of same type");
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

   public Value buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      Value v = null;
      if (this.operator == Operator.PLUS) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         AddInstruction instr = new AddInstruction(v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
      }
      else if (this.operator == Operator.MINUS) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         SubInstruction instr = new SubInstruction(v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
      }
      else if (this.operator == Operator.TIMES) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         MulInstruction instr = new MulInstruction(v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
      }
      else if (this.operator == Operator.DIVIDE) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         SdivInstruction instr = new SdivInstruction(v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
      }
      else if (this.operator == Operator.LT) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         IcmpInstruction instr = new IcmpInstruction("slt", new iType(64), v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
         ZextInstruction instr2 = new ZextInstruction(new iType(1), v, new Register(new iType(64)));
         curBlock.addInstruction(instr2);
         v = instr2.getReg();
      }
      else if (this.operator == Operator.GT) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         IcmpInstruction instr = new IcmpInstruction("sgt", new iType(64), v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
         ZextInstruction instr2 = new ZextInstruction(new iType(1), v, new Register(new iType(64)));
         curBlock.addInstruction(instr2);
         v = instr2.getReg();
      }
      else if (this.operator == Operator.LE) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         IcmpInstruction instr = new IcmpInstruction("sle", new iType(64), v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
         ZextInstruction instr2 = new ZextInstruction(new iType(1), v, new Register(new iType(64)));
         curBlock.addInstruction(instr2);
         v = instr2.getReg();
      }
      else if (this.operator == Operator.GE) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         IcmpInstruction instr = new IcmpInstruction("sge", new iType(64), v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
         ZextInstruction instr2 = new ZextInstruction(new iType(1), v, new Register(new iType(64)));
         curBlock.addInstruction(instr2);
         v = instr2.getReg();
      }
      else if (this.operator == Operator.EQ) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         IcmpInstruction instr = new IcmpInstruction("eq", v1.getRegType(), v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
         ZextInstruction instr2 = new ZextInstruction(new iType(1), v, new Register(new iType(64)));
         curBlock.addInstruction(instr2);
         v = instr2.getReg();
      }
      else if (this.operator == Operator.NE) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         IcmpInstruction instr = new IcmpInstruction("ne", v1.getRegType(), v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
         ZextInstruction instr2 = new ZextInstruction(new iType(1), v, new Register(new iType(64)));
         curBlock.addInstruction(instr2);
         v = instr2.getReg();
      }
      else if (this.operator == Operator.AND) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         AndInstruction instr = new AndInstruction(v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
      }
      else if (this.operator == Operator.OR) {
         Value v1 = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         Value v2 = right.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         OrInstruction instr = new OrInstruction(v1, v2);
         curBlock.addInstruction(instr);
         v = instr.getReg();
      }
      else {
         return null;
      }
      
      return v;
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
