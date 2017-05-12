package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class FuncInvocationInstruction
   implements Instruction
{
   private final String name;
   private final List<Value> reg;
   private final String returnString;
   private final Register saveReg;

   public FuncInvocationInstruction(String name, List<Value> r, String returnString, Register saveReg) {
      this.name = name;
      this.reg = r;
      this.returnString = returnString;
      this.saveReg = saveReg;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.print("\t" + saveReg.getRegName() + " = call " + returnString + " @" + name + "(");
      for (int i = 0; i < reg.size(); i++) {
         outFile.print(reg.get(i).getRegType().getLLVMTypeName() + " " + reg.get(i).getRegName());
         if (i != (reg.size() - 1)) {
            outFile.print(", ");
         }
      }
      outFile.println(")");
   }
}
