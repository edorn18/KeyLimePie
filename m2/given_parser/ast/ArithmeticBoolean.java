package ast;

import java.util.Hashtable;
import java.util.List;

public class ArithmeticBoolean
   implements Instruction
{
   private final String instrName;
   private final LLVMType ty;
/*   private final LLVMType leftRegType;
   private final String leftRegName;
   private final LLVMType rightRegType;
   private final String rightRegName; */
   private final Value left;
   private final Value right;
   private final Register result;

   public ArithmeticBoolean(String instrName, LLVMType ty, Value left, Value right, Register result)
   {  
      this.instrName = instrName;
      this.ty = ty; 
/*      this.leftRegType = left.getRegType();
      this.leftRegName = left.getRegName();
      this.rightRegType = right.getRegType();
      this.rightRegName = right.getRegName();*/
      this.left = left;
      this.right = right;
      this.result = result;
   }

   public void printInstruction() {
      //System.out.println("%u#" + " = " + instrName + " " + ty.getLLVMTypeName()
	//+ " %u#, " + " %u#");
   }
}

