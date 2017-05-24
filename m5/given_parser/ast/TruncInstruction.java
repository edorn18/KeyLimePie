package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class TruncInstruction
   implements Instruction
{
   private final Value value; 
   private LLVMType valueType;
   private LLVMType convertType;
   private final Register reg;

   public TruncInstruction(Value value, LLVMType convertType) {
      this.value = value;
      this.valueType = value.getRegType(); 
      this.convertType = convertType;
      this.reg = new Register(convertType);
   }   

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + reg.getRegName() + " = trunc " + valueType.getLLVMTypeName() + " " + value.getRegName() + " to " + convertType.getLLVMTypeName());
   } 

   public Register getReg() {
      return reg;
   }   
}
