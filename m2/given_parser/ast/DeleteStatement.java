package ast;

import java.util.Hashtable;
import java.util.List;

public class DeleteStatement
   extends AbstractStatement
{
   private final Expression expression;

   public DeleteStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (!(expression.checkType(funcTable, structTable, retType) instanceof StructType || expression.checkType(funcTable, structTable, retType) instanceof NullType)) {
         throw new IllegalArgumentException("Delete expression must be a struct or null");
      }
   }

   public boolean checkReturn(Type retType) {
      return false;
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      
      Value v = expression.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
      Value v2 = new Register(new iType(8, 1)); 
      BitCastInstruction instr1 = new BitCastInstruction(v, v2);
      Value v3 = instr1.getReg();
      curBlock.addInstruction(instr1);
      curBlock.addInstruction(new CallFreeInstruction(v3));

      return curBlock;
   }
}
