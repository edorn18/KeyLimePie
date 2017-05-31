package ast;

public class iType
   implements LLVMType
{
   protected int numBits; // 1->bool, 8->struct, 64->int
   protected int numPointers;

   public iType(int numBits)
   {
      this.numBits = numBits;
      this.numPointers = 0;
   }

   public iType(int numBits, int numPointers) {
      this.numBits = numBits;
      this.numPointers = numPointers;
   } 
   
   public String getLLVMTypeName() {
      String stars = "";
      
      for (int i = 0; i < numPointers; i++) {
         stars = stars + "*";
      }

      return "i" + numBits + stars;
   }

   public String getName() {
      return "THIS SHOULD NEVER HAPPEN";
   }   
}
