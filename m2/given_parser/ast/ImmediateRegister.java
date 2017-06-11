package ast;

import java.util.Hashtable;

public class ImmediateRegister
   implements Value
{
   private final String value;
   private final LLVMType type;

   public ImmediateRegister(String value)
   {   
      this.value = value;
      this.type = new iType(64);
   } 

   public ImmediateRegister(String value, LLVMType t)
   {
      this.value = value;
      this.type = t;
   }

   public LLVMType getRegType() {
      return type;
   }

   public String getRegName() {
      return value;
   }

   public String getRegNameNoSym() {
      return value;
   }
}
