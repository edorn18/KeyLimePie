package ast;

public class iType
   implements LLVMType
{
   private final int numBits; // 1->bool, 8->struct, 64->int

   public iType(int numBits)
   {
      this.numBits = numBits;
   }   
   
   public String getLLVMTypeName() {
      return "i" + numBits;
   }   
}
