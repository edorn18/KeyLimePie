package ast;

import java.util.Hashtable;

public class Register
   implements Value
{
   private final LLVMType regType;
//   private final iType regType;
   private final String regName;
   private final int regNum;
   public static int regTracker = 0;

   public Register(LLVMType regType)
   {   
      this.regType = regType;
      this.regNum = regTracker;
      this.regName = "%u" + regNum;
      this.regTracker++;
   } 

   public LLVMType getRegType() {
      return this.regType;
   } 

   public String getRegName() {
      return this.regName;
   }

   public int getRegNum() {
      return this.regNum;
   }
}  
