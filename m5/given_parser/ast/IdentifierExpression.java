package ast;

import java.util.Hashtable;
import java.util.List;

public class IdentifierExpression
   extends AbstractExpression
{
   private final String id;

   public IdentifierExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      //System.out.println("Checking IdentifierExpression");
      if (funcTable.get(id) == null) {
         throw new IllegalArgumentException("Id was not found");
      }
      //System.out.println("This was the type found: " + funcTable.get(id).getClass().getName());
      return funcTable.get(id);
   }

   public Value buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      LoadInstruction ldInstr = null;

      if (localTable.get(id) != null) {
         if (localTable.get(id) instanceof StructType) {
            ldInstr = new LoadInstruction(new LLVMStructType(((StructType)(localTable.get(id))).getStructName()), varTable.get(id));
            curBlock.addInstruction(ldInstr);
         }
         else {
            ldInstr = new LoadInstruction(new iType(64), varTable.get(id));
            curBlock.addInstruction(ldInstr);
         }
      }
      else {
         if (globalTable.get(id) != null) {
            if (globalTable.get(id) instanceof StructType) {
            ldInstr = new LoadInstruction(new LLVMStructType(((StructType)(localTable.get(id))).getStructName()), id);
            curBlock.addInstruction(ldInstr);
            }
            else {
               ldInstr = new LoadInstruction(new iType(64), id);
               curBlock.addInstruction(ldInstr);
            }
         }
      }
      return ldInstr.getReg();

   }
}
