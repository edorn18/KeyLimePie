package ast;

import java.util.Hashtable;

public class ImmediateRegister
   implements Value
{
   private final String value;

   public ImmediateRegister(String value)
   {   
      this.value = value;
   } 

   public LLVMType getRegType() {
      return new iType(64);
   }

   public String getRegName() {
      return value;
   } 
}
