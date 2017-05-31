package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class CallMallocInstruction
   implements Instruction
{
   private final LLVMType varType;
   private final Register reg;
   private int space;

   public CallMallocInstruction(int space) {
      this.varType = new iType(8, 1);
      this.reg = new Register(varType);
      this.space = space * 8;
   }

   public Register getReg() {
      return reg;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + reg.getRegName() + " = call " + varType.getLLVMTypeName() + " @malloc(i64 " + space + ")");
   }
}
