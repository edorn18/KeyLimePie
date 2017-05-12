package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class PrintInstruction
   implements Instruction
{
   private final Value reg;

   public PrintInstruction(Value r) {
      this.reg = r;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tcall i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), " + reg.getRegType().getLLVMTypeName() + " " + reg.getRegName() + ")");
   }
}
