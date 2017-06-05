package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class ZextInstruction
   implements Instruction
{
   private final LLVMType type;
   private final Value value; 
   private LLVMType valueType;
   private final Value convertVal; 
   private LLVMType convertType;
   private final Register reg;

   public ZextInstruction(LLVMType type, Value value, Value convertVal) {
      this.value = value;
      this.valueType = value.getRegType(); 
      this.convertType = convertVal.getRegType();
      this.convertVal = convertVal;
      this.reg = new Register(convertType);
      this.type = type;
   }   

   public void printInstruction(PrintWriter outFile) {
      outFile.println("\t" + reg.getRegName() + " = zext " + type.getLLVMTypeName() + " " + value.getRegName() + " to " + convertType.getLLVMTypeName());
   } 

   public Register getReg() {
      return reg;
   }   
}
