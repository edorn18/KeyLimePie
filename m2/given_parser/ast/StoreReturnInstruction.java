package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class StoreReturnInstruction
   implements Instruction
{
   private final LLVMType t1;
   private final Value v1;

   public StoreReturnInstruction(LLVMType t1, Value v1) {
      this.t1 = t1;
      this.v1 = v1;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tSTORE INSTRUCTION");
   }
}
