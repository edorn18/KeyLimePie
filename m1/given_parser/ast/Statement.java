package ast;

import java.util.Hashtable;

public interface Statement
{
   public Type checkType(Hashtable<String, Hashtable<String,Type>> funcTable, Hashtable<String, Hashtable<String,Type>> structTable);
}
