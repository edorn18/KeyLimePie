package ast;

import java.util.Hashtable;
import java.util.List;

public class ComparisonAndBranching
   implements Instruction
{
   private final String instrName;
   private final Value op1;
   private final Value op2;
   //private final Register result;

   public ComparisonAndBranching(String instrName, LLVMConditional cond, LLVMType ty, Value op1, Value op2)
   {   
      this.instrName = instrName; 
      this.op1 = op1;
      this.op2 = op2;
      //this.result = result;
   }   

   /*public void printInstr() {
 *
 *    }*/
}
