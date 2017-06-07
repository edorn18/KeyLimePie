package ast;

//import java.util.Hashtable;

public interface Value
{
public LLVMType getRegType();
public String getRegName();
public String getRegNameNoSym();
}
