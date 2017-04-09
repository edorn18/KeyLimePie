package ast;

import java.util.List;

public class Program
{
   private final List<TypeDeclaration> types;
   private final List<Declaration> decls;
   private final List<Function> funcs;

   public Program(List<TypeDeclaration> types, List<Declaration> decls,
      List<Function> funcs)
   {
      this.types = types;
      this.decls = decls;
      this.funcs = funcs;
   }

   public void printAll() {
      printTypes();
      printDecls();
      printFuncs();
   }

   private void printTypes() {
      System.out.println("Printing the type list");
      for (int i = 0; i < types.size(); i++) {
         System.out.println(types.get(i).getTypeName());
      }
      System.out.println("");
   }

   private void printDecls() {
      System.out.println("Printing the decl list");
      for (int i = 0; i < decls.size(); i++) {
         System.out.println(decls.get(i).getDeclName());
      }
      System.out.println("");
   }

   private void printFuncs() {
      System.out.println("Printing the func list");
      for (int i = 0; i < funcs.size(); i++) {
         System.out.println(funcs.get(i).getFunctionName());
      }
      System.out.println("");
   }
}
