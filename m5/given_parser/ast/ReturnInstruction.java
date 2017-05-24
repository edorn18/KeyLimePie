package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class ReturnInstruction
   implements Instruction
{
   Value v;

   public ReturnInstruction(Value v) {
      this.v = v;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tret " + v.getRegType().getLLVMTypeName() + " " +  v.getRegName());
   }

}
