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
   private final String typeString;

   public LoadInstruction(LLVMType varType, String varName) {
      this.reg = new Register(varType);
      this.varName = varName;
      this.varType = varType;
      this.typeString = "%";
   }

   public LoadInstruction(LLVMType varType, String varName, int global) {
      this.reg = new Register(varType);
      this.varName = varName;
      this.varType = varType;
      this.typeString = "@";
   }


   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + reg.getRegName() + " = load " + varType.getLLVMTypeName() + "* " + typeString + varName);   
   }

   public Register getReg() {
      return reg;
   }
}
