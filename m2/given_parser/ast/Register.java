package ast;

import java.util.Hashtable;

public class Register
   implements Value
{
   private final LLVMType regType;
   private final String regName;
   private final String regNameNoSym;
   public static int regTracker = 0;

   public Register(LLVMType regType)
   {   
      this.regType = regType;
      this.regNameNoSym = "u" + regTracker;
      this.regName = "%u" + regTracker;
      this.regTracker++;
   }

   public Register(LLVMType regType, String regName) {
      this.regType = regType;
      this.regNameNoSym = regName;
      this.regName = "%" + regName;
   }

   public Register(LLVMType regType, String regName, int global) {
      this.regType = regType;
      this.regNameNoSym = regName;
      this.regName = "@" + regName;
   } 

   public LLVMType getRegType() {
      return this.regType;
   } 

   public String getRegName() {
      return this.regName;
   }

   public String getRegNameNoSym() {
      return this.regNameNoSym;
   }

}  
