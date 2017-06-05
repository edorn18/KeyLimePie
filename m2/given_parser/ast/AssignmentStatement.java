package ast;

import java.util.Hashtable;
import java.util.List;

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
      //System.out.println("This is the target's type: " + target.checkType(funcTable, structTable, retType).getClass().getName());


      if (target.checkType(funcTable, structTable, retType) instanceof IntType) {
         //System.out.println("This is the source's type: " + source.checkType(funcTable, structTable, retType).getClass().getName());

         if (!(source.checkType(funcTable, structTable, retType) instanceof IntType)) {
            throw new IllegalArgumentException("Line #: " + lineNum + "Left and right hand side must be of same type.");
         }
      }
      else if (target.checkType(funcTable, structTable, retType) instanceof BoolType) {
         if (!(source.checkType(funcTable, structTable, retType) instanceof BoolType)) {
            throw new IllegalArgumentException("Line #: " + lineNum + "Left and right hand side must be of same type.");
         }
      }
      else if (target.checkType(funcTable, structTable, retType) instanceof StructType) {
         if (!(source.checkType(funcTable, structTable, retType) instanceof StructType) && !(source.checkType(funcTable, structTable, retType) instanceof NullType)) {
            throw new IllegalArgumentException("Line #: " + lineNum + "Left and right hand side must be of same type.");
         }
      }
      else {
         throw new IllegalArgumentException("Line #: " + lineNum + "- Left hand side has invalid type.");
      }
   }

   public boolean checkReturn(Type retType) {
      return false;
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      if (source instanceof ReadExpression) {
         curBlock.addInstruction(new ReadInstruction(new iType(64), target.getName()));
      }
      else {
         Value r = source.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
         if (target instanceof LvalueId) {
            String targName = varTable.get(target.getName());
            curBlock.addInstruction(new StoreInstruction(r.getRegType(), r, r.getRegType(), new Register(r.getRegType(), targName)));
         }
         else {
            Value r2 = ((LvalueDot)(target)).buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
            curBlock.addInstruction(new StoreInstruction(r.getRegType(), r, r.getRegType(), r2));
         }

      }
         
      return curBlock;
   }

}
