package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class LoadInstruction
   implements Instruction
{
   private final Register reg;
   private final iType varType;
   private final String varName;

   public LoadInstruction(iType varType, String varName) {
      this.reg = new Register(new iType(64));
      this.varName = varName;
      this.varType = varType;
   }

   public void printInstruction(PrintWriter outFile) {
       
   }
}
