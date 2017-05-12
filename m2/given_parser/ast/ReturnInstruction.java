package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class ReturnInstruction
   implements Instruction
{

   public ReturnInstruction(LLVMType varType, String varName) {
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t");
   }

}
