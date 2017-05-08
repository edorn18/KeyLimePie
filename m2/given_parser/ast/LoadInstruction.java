package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class LoadInstruction
   implements Instruction
{
   private final Register reg;
   private final LLVMType varType;
   private final String varName;

   public LoadInstruction(LLVMType varType, String varName) {
      this.reg = new Register(varType);
      this.varName = varName;
      this.varType = varType;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t%" + reg.getRegNum() + " = load " + varType.getLLVMTypeName() + "* %" + varName);   
   }
}
