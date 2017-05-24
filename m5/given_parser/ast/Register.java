package ast;

import java.util.Hashtable;

public class Register
   implements Value
{
   private final LLVMType regType;
   private final String regName;
   public static int regTracker = 0;

   public Register(LLVMType regType)
   {   
      this.regType = regType;
      this.regName = "%u" + regTracker;
      this.regTracker++;
   }

   public Register(LLVMType regType, String regName) {
      this.regType = regType;
      this.regName = "%" + regName;
   } 

   public LLVMType getRegType() {
      return this.regType;
   } 

   public String getRegName() {
      return this.regName;
   }

}  
