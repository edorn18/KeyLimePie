package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class CallFreeInstruction
   implements Instruction
{
   private Value v; 

   public CallFreeInstruction(Value v) {
      this.v = v;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + "call void @free(" + v.getRegType().getLLVMTypeName() + " " + v.getRegName() + ")");
   }
}
