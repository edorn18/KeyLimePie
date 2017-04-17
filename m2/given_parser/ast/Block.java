package ast;

import java.util.List;
import java.util.ArrayList;

public class Block {
   private String name;
   private int label;
   private List<Block> blockList;

   public Block(int label) {
      this.label = label;
      this.blockList = new ArrayList<Block>();
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
}
