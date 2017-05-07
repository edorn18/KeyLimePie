package ast;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;

public class Block {
   private String name;
   private int label;
   private List<Block> blockList;
   private List<Instruction> instructionList; 

   public Block(int label) {
      this.label = label;
      this.blockList = new ArrayList<Block>();
      this.instructionList = new ArrayList<Instruction>();
   }

   public void addBlock(Block b) {
      blockList.add(b);
   }

   public int getLabel() {
      return label;
   }

   public List<Block> getList() {
      return blockList;
   }

   public void addInstruction(Instruction i) {
      instructionList.add(i);
   }

   public void printInstructions(PrintWriter outFile) {
      for (int i = 0; i < instructionList.size(); i++) {
         instructionList.get(i).printInstruction(outFile);
      }
   }
}
