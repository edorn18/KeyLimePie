package ast;

import java.util.Hashtable;

public class Register
   implements Value
{
   private final String value;

   public Register(int lineNum, String value)
   {   
      this.value = value;
   } 
}  
