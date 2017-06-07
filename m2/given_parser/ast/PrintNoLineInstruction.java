package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class PrintNoLineInstruction
   implements Instruction
{
   private final Value reg;

   public PrintNoLineInstruction(Value r) {
      this.reg = r;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tcall i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.print, i32 0, i32 0), " + reg.getRegType().getLLVMTypeName() + " " + reg.getRegName() + ")");
   }
}
