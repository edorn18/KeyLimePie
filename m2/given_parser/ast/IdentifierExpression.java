package ast;

import java.util.Hashtable;

public class IdentifierExpression
   extends AbstractExpression
{
   private final String id;

   public IdentifierExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      //System.out.println("Checking IdentifierExpression");
      if (funcTable.get(id) == null) {
         throw new IllegalArgumentException("Id was not found");
      }
      //System.out.println("This was the type found: " + funcTable.get(id).getClass().getName());
      return funcTable.get(id);
   }

//   public Value buildInstruction(LLVMType ty, int regNum) {  // returns a Register

//load
//new reg -> result of the load
//return that ^
//pass block, add instr to block

/*      regNum++;
      return new Register(ty, regNum);
   }*/
}
