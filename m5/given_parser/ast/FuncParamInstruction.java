package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class FuncParamInstruction
   implements Instruction
{
   private final String varName;
   private final LLVMType varType;

   public FuncParamInstruction(String varName, LLVMType varType) {
      this.varName = varName;
      this.varType = varType;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t%_P_" + varName + " = alloca " + varType.getLLVMTypeName());
   }
}
