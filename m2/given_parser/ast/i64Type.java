package ast;

public class i64Type
   implements LLVMType
{
   private final int lineNum;
   private final String name;

   public i64Type(int lineNum, String name)
   {   
      this.lineNum = lineNum;
      this.name = name;
   }   

}
