package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class FuncLocalInstruction
   implements Instruction
{
   private final String varName;
   private final iType varType;

   public FuncLocalInstruction(String varName, iType varType) {
      this.varName = varName;
      this.varType = varType;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t%" + varName + " = alloca " + varType.getLLVMTypeName());
   }
}
