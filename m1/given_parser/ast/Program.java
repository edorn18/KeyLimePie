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
      for (int i = 0; i < types.size(); i++) {
         System.out.println(types.get(i).getTypeName());
      }
   }

   private void printDecls() {
      for (int i = 0; i < decls.size(); i++) {
         System.out.println(decls.get(i).getDeclName());
      }
   }

   private void printFuncs() {
      for (int i = 0; i < funcs.size(); i++) {
         System.out.println(funcs.get(i).getFunctionName());
      }
   }
}
