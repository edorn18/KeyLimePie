package ast;

import java.util.Hashtable;
import java.util.List;

public interface Statement
{
   public void checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType);
   public boolean checkReturn(Type retType);
   public void buildBlock(List<Block> allBlockList);
}
