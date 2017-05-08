package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class FuncLocalInstruction
   implements Instruction
{
   private final String varName;
   private final LLVMType varType;

   public FuncLocalInstruction(String varName, LLVMType varType) {
      this.varName = varName;
      this.varType = varType;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t%" + varName + " = alloca " + varType.getLLVMTypeName());
   }
}
