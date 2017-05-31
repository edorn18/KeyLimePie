package ast;

public class LLVMStructType
   implements LLVMType
{
   private final String structName;
   private final int numBits; // 1->bool, 8->struct, 64->int

   public LLVMStructType(String structName)
   {
      this.structName = structName;
      this.numBits = 8;
   }

   public String getLLVMTypeName() {
      return "%struct." + structName + "*";
   }
 
   public String getName() {
      return structName;
   }
}
