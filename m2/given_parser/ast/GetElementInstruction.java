package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class GetElementInstruction
   implements Instruction
{
   private final Register reg;
   private final Value v;
   private final int index;

   public GetElementInstruction(Value v, int index) {
      this.reg = new Register(v.getRegType());
      this.v = v;
      this.index = index;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + reg.getRegName() + " = getelementptr " + v.getRegType().getLLVMTypeName() + " " + v.getRegName() + ", i1 0, i32 " + index);   
   }

   public Register getReg() {
      return reg;
   }
}
