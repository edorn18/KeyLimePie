package ast;

import java.util.Hashtable;

public interface Lvalue
{
   public Type checkType(Hashtable<String,Type> funcTable, Hashtable<String, Hashtable<String,Type>> structTable, Type retType);
}
