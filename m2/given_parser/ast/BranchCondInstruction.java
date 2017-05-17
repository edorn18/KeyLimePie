package ast;

import java.util.List;
import java.io.PrintWriter;

public class BranchCondInstruction
   implements Instruction
{
   Value condReg;
   Block firstBlock;
   Block secondBlock;

   public BranchCondInstruction(Value condReg, Block firstBlock, Block secondBlock) {
      this.condReg = condReg;
      this.firstBlock = firstBlock;
      this.secondBlock = secondBlock;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\tbr i1 " + condReg.getRegName() + ", label %LU" + firstBlock.getLabel() + ", label %LU" + secondBlock.getLabel());
   }
}
