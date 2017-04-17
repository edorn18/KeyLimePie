package ast;

import java.util.List;

public class Block {
   private String name;
   private int label;
   private List<Block> blockList;

   public Block(int label) {
      this.label = label;
   }

   public void addBlock(Block b) {
      blockList.add(b);
   }

   public int getLabel() {
      return label;
   }
}
