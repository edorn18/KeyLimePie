package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class SdivInstruction
   implements Instruction
{
   private final Register reg;
   private final LLVMType varType;
   private final Value v1;
   private final Value v2;

   public SdivInstruction(Value v1, Value v2) {
      varType = new iType(64);
      this.reg = new Register(varType);
      this.v1 = v1;
      this.v2 = v2;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + reg.getRegName() + " = sdiv " + varType.getLLVMTypeName() + " " + v1.getRegName() + ", " + v2.getRegName());
   }

   public Register getReg() {
      return reg;
   }
}
