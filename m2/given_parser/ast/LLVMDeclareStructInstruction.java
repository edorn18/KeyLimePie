package ast;

import java.util.Hashtable;
import java.util.List;
import java.io.PrintWriter;

public class LLVMDeclareStructInstruction
   implements Instruction
{
   private final String structName;
   private final List<LLVMType> typeList;

   public LLVMDeclareStructInstruction(String structName, List<LLVMType> typeList)
   {   
      this.structName = structName;
      this.typeList = typeList;
   } 
  
   public void printInstruction(PrintWriter outFile) {
      outFile.print("%struct." + this.structName + " = type {");
      for (int i = 0; i < typeList.size(); i++) {
         if (i < typeList.size() - 1) {
            outFile.print(typeList.get(i).getLLVMTypeName() + ", ");
         }
         else {
            outFile.print(typeList.get(i).getLLVMTypeName());
         }
      }
      outFile.println("}");
   } 
}
