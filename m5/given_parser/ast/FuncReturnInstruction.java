package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class FuncReturnInstruction
   implements Instruction
{
   private final String varName;
   private final LLVMType varType;
   
   public FuncReturnInstruction(LLVMType varType) {
      this.varName = "_retval_";
      this.varType = varType;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t%" + varName + " = alloca " + varType. getLLVMTypeName());
   }
}
