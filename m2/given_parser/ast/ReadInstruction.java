package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class ReadInstruction
   implements Instruction
{
   private LLVMType t;
   private String varName;
   private final String typeString;

   public ReadInstruction(LLVMType type, String varName) {
      this.t = type;
      this.varName = varName;
      this.typeString = "%";
   }

   public ReadInstruction(LLVMType type, String varName, int global) {
      this.t = type;
      this.varName = varName;
      this.typeString = "@";
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tcall i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), " + t.getLLVMTypeName() + "* " + typeString + varName + ")");
   }
}
