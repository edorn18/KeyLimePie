package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class IcmpInstruction
   implements Instruction
{
   private final Register reg;
   private final String cond;
   private final LLVMType varType;
   private final Value v1;
   private final Value v2;

   public IcmpInstruction(String cond, LLVMType varType, Value v1, Value v2) {
      this.reg = new Register(varType);
      this.cond = cond;
      this.varType = varType;
      this.v1 = v1;
      this.v2 = v2;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + reg.getRegName() + " = icmp " + cond + " " + varType.getLLVMTypeName() + " " + v1.getRegName() + ", " + v2.getRegName());   
   }

   public Register getReg() {
      return reg;
   }
}
