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

   public Value buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      Value r, r2, r3;
      int size = 0;
System.out.println("id is: " + id);
      for (int i = 0; i < types.size(); i++) {
         System.out.println("type name is: " + types.get(i).getTypeName());
         if (types.get(i).getTypeName() == id) {
            size = types.get(i).getFields().size();
      System.out.println("size1 is: " + size);
         }
      }

      System.out.println("size2 is: " + size);

      CallMallocInstruction instr = new CallMallocInstruction(size); 
      curBlock.addInstruction(instr);
      r = instr.getReg();
      r2 = new Register(new LLVMStructType(id), id);
      BitCastInstruction instr2 = new BitCastInstruction(r, r2);
      curBlock.addInstruction(instr2);
      r3 = instr2.getReg();

      return r3;
   }
}
