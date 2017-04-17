package ast;

import java.util.Hashtable;
import java.util.List;

public interface Statement
{
   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType);
   public boolean checkReturn(Type retType);
   public Block buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock);
}
