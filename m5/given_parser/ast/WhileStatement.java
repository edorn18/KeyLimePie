package ast;

import java.util.Hashtable;
import java.util.List;

public class WhileStatement
   extends AbstractStatement
{
   private final Expression guard;
   private final Statement body;

   public WhileStatement(int lineNum, Expression guard, Statement body)
   {
      super(lineNum);
      this.guard = guard;
      this.body = body;
   }
  
   public void checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) { 
      if (!(guard.checkType(funcTable, structTable, retType) instanceof BoolType)) {
         throw new IllegalArgumentException("Guard does not evaluate to bool type");
      }
      body.checkType(funcTable, structTable, retType);
   }

   public boolean checkReturn(Type retType) {
      return false;
   }

   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      Block trueBlock;
      Block falseBlock;
      Block tempBlock;

      trueBlock = new Block(allBlockList.size());
      allBlockList.add(trueBlock);

      tempBlock = body.buildBlock(allBlockList, trueBlock, endBlock, globalTable, localTable, varTable, types);
      tempBlock.addBlock(trueBlock);

      falseBlock = new Block(allBlockList.size());
      allBlockList.add(falseBlock);
      tempBlock.addBlock(falseBlock);

      Value v = guard.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
      TruncInstruction truncInst = new TruncInstruction(v, new iType(1));
      curBlock.addInstruction(truncInst);
      curBlock.addInstruction(new BranchCondInstruction(truncInst.getReg(), trueBlock, falseBlock));

      Value v2 = guard.buildBlock(allBlockList, trueBlock, endBlock, globalTable, localTable, varTable, types);
      TruncInstruction truncInst2 = new TruncInstruction(v2, new iType(1));
      trueBlock.addInstruction(truncInst2);
      trueBlock.addInstruction(new BranchCondInstruction(truncInst2.getReg(), trueBlock, falseBlock));

      curBlock.addBlock(trueBlock);
      curBlock.addBlock(falseBlock);

      return falseBlock;
   }
}
