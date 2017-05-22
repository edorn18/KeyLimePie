package ast;

import java.util.Hashtable;
import java.util.List;

public class NewExpression
   extends AbstractExpression
{
   private final String id;

   public NewExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }
 
   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) { 
//      System.out.println("Checking NewExpression");
      return new StructType(lineNum, id);
   }

   public Value buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable) {
      Value r, r2, r3;

      CallMallocInstruction instr = new CallMallocInstruction(3);      
      curBlock.addInstruction(instr);
      r = instr.getReg();
      r2 = new Register(new LLVMStructType(id), id);
      BitCastInstruction instr2 = new BitCastInstruction(r, r2);
      curBlock.addInstruction(instr2);
      r3 = instr2.getReg();

      return r3;
   }
}
