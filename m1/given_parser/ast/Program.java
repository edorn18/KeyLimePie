package ast;

import java.util.List;
import java.util.Hashtable;

public class Program
{
   private final List<TypeDeclaration> types;
   private final List<Declaration> decls;
   private final List<Function> funcs;

   private Hashtable<String,Type> globalTable; 
   private Hashtable<String, Hashtable<String,Type>> structTable;
   private Hashtable<String, Hashtable<String,Type>> funcTable;

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
      makeSymbolTables();
      checkForMain();
   }

   public void makeSymbolTables() {
      makeGlobalTable();
      makeStructTable();
      makeFuncTable();
   }

   private void makeGlobalTable() {
      globalTable = new Hashtable<String,Type>();
      for (int i = 0; i < decls.size(); i++) {
         globalTable.put(decls.get(i).getDeclName(), decls.get(i).getDeclType());
      }
   }

   private void makeStructTable() {
      Hashtable<String,Type> fieldsTable;
      List<Declaration> fieldsList;

      structTable = new Hashtable<String, Hashtable<String,Type>>();
      for (int i = 0; i < types.size(); i++) {
         System.out.println("Adding a struct");
         fieldsTable = new Hashtable<String,Type>();
         fieldsList = types.get(i).getFields();
         for (int j = 0; j < fieldsList.size(); j++) {
            fieldsTable.put(fieldsList.get(j).getDeclName(), decls.get(j).getDeclType());
         }
         structTable.put(types.get(i).getTypeName(), fieldsTable);
      }
   }

   private void makeFuncTable() {
      Hashtable<String,Type> globalClone;
      List<Declaration> paramList;
      List<Declaration> localList;

      funcTable = new Hashtable<String, Hashtable<String, Type>>();
      for (int i = 0; i < funcs.size(); i++) {
         System.out.println("Adding a function");
         globalClone = (Hashtable<String,Type>) globalTable.clone();
         paramList = funcs.get(i).getFunctionParams();
         localList = funcs.get(i).getFunctionLocals();
         for (int j = 0; j < paramList.size(); j++) {
            globalClone.put(paramList.get(j).getDeclName(), paramList.get(j).getDeclType());
         }
         for (int j = 0; j < localList.size(); j++) {
            globalClone.put(localList.get(j).getDeclName(), localList.get(j).getDeclType());
         }
         funcTable.put(funcs.get(i).getFunctionName(), globalClone);
         System.out.println("Here is the global table");
         System.out.println(globalTable);
         System.out.println("Here is the function table");
         System.out.println(globalClone);
      }
   }

   public void checkForMain() {
      if (funcTable.get("main") == null) {
         System.out.println("There is no main\n");
      }
   }

   public void checkType() {
      for (int i = 0; i < funcs.size(); i++) {
         //funcs.get(i).getBody().checkType(funcTable.get(funcs.get(i).getFunctionName()), structTable);
      }
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
