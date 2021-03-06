package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class StoreInstruction
   implements Instruction
{
   private final LLVMType t1;
   private final Value v1;
   private final LLVMType t2;
   private final Value v2;

   public StoreInstruction(LLVMType t1, Value v1, LLVMType t2, Value v2) {
      this.t1 = t1;
      this.v1 = v1;
      this.t2 = t2;
      this.v2 = v2;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tstore " + t1.getLLVMTypeName() + " " + v1.getRegName() + ", " + t2.getLLVMTypeName() + "* " + v2.getRegName());
   }
}
