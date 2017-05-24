package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class ReturnVoidInstruction
   implements Instruction
{

   public ReturnVoidInstruction() {
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tret void");
   }

}
