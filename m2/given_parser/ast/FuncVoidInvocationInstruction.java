package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class FuncVoidInvocationInstruction
   implements Instruction
{
   private final String name;
   private final List<Value> reg;
   private final String returnString;

   public FuncVoidInvocationInstruction(String name, List<Value> r, String returnString) {
      this.name = name;
      this.reg = r;
      this.returnString = returnString;
   }

   public void printInstruction(PrintWriter outFile) {
      outFile.print("\tcall " + returnString + " @" + name + "(");
      for (int i = 0; i < reg.size(); i++) {
         outFile.print(reg.get(i).getRegType().getLLVMTypeName() + " " + reg.get(i).getRegName());
         if (i != (reg.size() - 1)) {
            outFile.print(", ");
         }
      }
      outFile.println(")");
   }
}
