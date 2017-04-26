package ast;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;

public class Comparison
   implements Instruction
{
   private final String instrName;
   //private final LLVMConditional cond;
   private final Value op1;
   private final Value op2;
   private final LLVMType ty;
   private final int iftrue;
   private final int iffalse;
   //private final Register result;

   public Comparison(String instrName, String cond, LLVMType ty, Value op1, Value op2, int iftrue, int iffalse)
   {   
      this.instrName = instrName; //icmp
      //this.cond = cond;
      this.ty = ty; //i64
      this.op1 = op1;
      this.op2 = op2;
      this.iftrue = iftrue;
      this.iffalse = iffalse;
      //this.result = result;
      
   }   

   public void printInstruction() {
   //   System.out.println("%u# icmp " + cond + " " + ty);
   }

   /*public void printInstr() {
 *
 *    }*/
}
