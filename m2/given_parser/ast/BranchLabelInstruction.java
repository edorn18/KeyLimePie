package ast;

import java.util.List;
import java.io.PrintWriter;

public class BranchLabelInstruction
   implements Instruction
{
   Block retBlock;

   public BranchLabelInstruction(Block retBlock) {
      this.retBlock = retBlock;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tbr label %LU" + retBlock.getLabel());
   }
}
