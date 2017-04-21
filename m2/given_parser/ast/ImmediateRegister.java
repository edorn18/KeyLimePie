package ast;

import java.util.Hashtable;

public class ImmediateRegister
   implements Value
{
   private final String value;

   public ImmediateRegister(int lineNum, String value)
   {   
      this.value = value;
   }   
}
