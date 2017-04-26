package ast;

import java.util.Hashtable;

public class Immediate
   implements Value
{
   private final LLVMType regType;
   //private final String regName;

   public Immediate(LLVMType regType, int regValue)
   {   
      this.regType = regType;
//      this.regName = regName;
   }   

   public LLVMType getRegType() {
      return this.regType;
   }   

  /* public String getRegName() {
      return this.regName;
   }*/ 
}
