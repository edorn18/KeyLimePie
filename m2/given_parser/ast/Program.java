package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.io.PrintWriter;

public class Program
{
   private final List<TypeDeclaration> types;
   private final List<Declaration> decls;
   private final List<Function> funcs;

   private Hashtable<String,Type> globalTable; 
   private Hashtable<String, Hashtable<String,Type>> structTable;
   private Hashtable<String, Hashtable<String,Type>> funcTable;

   private List<Block> allBlockList = new ArrayList<Block>();
   private List<Block> startBlockList = new ArrayList<Block>();
   private List<Block> endBlockList = new ArrayList<Block>();

   public Program(List<TypeDeclaration> types, List<Declaration> decls,
      List<Function> funcs)
   {
      this.types = types;
      this.decls = decls;
      this.funcs = funcs;
   }

   public void printAll() {
      //printTypes();
      //printDecls();
      //printFuncs();
      makeSymbolTables();
      try {
         System.out.println("Checking for main...");
         checkForMain();
         System.out.println("Successfully found main function");
         System.out.println("Running type checking...");
         checkType();
         System.out.println("Finished type checking successfully with no errors");
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println(e.toString());
      }
      try {
      printCFG();
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
      printLlvmFile();
   }

   public void printCFG() {
      for (int i = 0; i < funcs.size(); i++) {
         funcs.get(i).buildCFG(allBlockList, startBlockList, endBlockList, globalTable);
      }

      for (int i = 0; i < allBlockList.size() ; i++) {
         System.out.println("Block " + allBlockList.get(i).getLabel());
         System.out.print("Links to block(s): ");
         for (int j = 0; j < allBlockList.get(i).getList().size(); j++) {
            System.out.print(allBlockList.get(i).getList().get(j).getLabel() + ", ");
         }
         System.out.println();
         System.out.println();
         // block i prints block i's links
      }
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
      for (int i = 0; i < funcs.size(); i++) {
         globalTable.put(funcs.get(i).getFunctionName(), new FuncType(funcs.get(i).getFunctionParams(), funcs.get(i).getFunctionRetType()));  
      }
   }

   public void printLlvmFile() {
      try {
         PrintWriter outFile = new PrintWriter("test.ll", "UTF-8");
         int funcCounter = 0;
         
         for (int i = 0; i < allBlockList.size(); i++) {
            if (funcCounter < startBlockList.size() && startBlockList.get(funcCounter) == allBlockList.get(i)) {
               String funcName = funcs.get(funcCounter).getFunctionName();
               if (funcCounter != 0) {
                  outFile.print("}\n\ndefine ");
               }
               else if (funcCounter == 0) {
                  outFile.print("define ");
               }
               if (!(funcs.get(funcCounter).getFunctionRetType() instanceof VoidType)) {
                  outFile.print("i64 ");
               }
               else {
                  outFile.print("void ");
               }
               outFile.println("@" + funcName + "()");
               outFile.println("{");
               outFile.println("LU" + allBlockList.get(i).getLabel() + ":");
               allBlockList.get(i).printInstructions(outFile);
               funcCounter++;
            }
            else {
               outFile.println("LU" + allBlockList.get(i).getLabel() + ":");
               allBlockList.get(i).printInstructions(outFile);
            }
//            outFile.println("");
         }
         outFile.print("}\n\n");
         outFile.println("declare i8* @malloc(i64)");
         outFile.println("declare void @free(i8*)");
         outFile.println("declare i32 @printf(i8*, ...)");
         outFile.println("declare i32 @scanf(i8*, ...)");
         outFile.println("@.println = private unnamed_addr constant [5 x i8] c\"%ld\\0A\\00\", align 1");
         outFile.println("@.print = private unnamed_addr constant [5 x i8] c\"%ld \\00\", align 1");
         outFile.println("@.read = private unnamed_addr constant [4 x i8] c\"%ld\\00\", align 1");
         outFile.println("@.read_scratch = common global i64 0, align 8");

         /*
         for (int i = 0; i < startBlockList.size(); i++) {
            String funcName = funcs.get(funcCounter).getFunctionName();
            outFile.print("define "); 
            outFile.println("@" + funcName + "()");
            outFile.println("{");
            outFile.println("}");
            outFile.println("");
            funcCounter++;
         }
         */
         outFile.close();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   private void makeStructTable() {
      Hashtable<String,Type> fieldsTable;
      List<Declaration> fieldsList;

      structTable = new Hashtable<String, Hashtable<String,Type>>();
      for (int i = 0; i < types.size(); i++) {
         //System.out.println("Adding a struct");
         fieldsTable = new Hashtable<String,Type>();
         fieldsList = types.get(i).getFields();
         for (int j = 0; j < fieldsList.size(); j++) {
            fieldsTable.put(fieldsList.get(j).getDeclName(), fieldsList.get(j).getDeclType());
            //System.out.println("This is id in struct followed by its type");
            //System.out.println(fieldsList.get(j).getDeclName() + " " + decls.get(j).getDeclType().getClass().getName());
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
         //System.out.println("Adding a function");
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
         //System.out.println("Here is the global table");
         //System.out.println(globalTable);
         //System.out.println("Here is the function table");
         //System.out.println(globalClone);
      }
   }

   public void checkForMain() {
      if (funcTable.get("main") == null) {
         throw new IllegalArgumentException("No main function was found");
      }
   }

   public void checkType() {
      for (int i = 0; i < funcs.size(); i++) {
         funcs.get(i).checkType(funcTable, structTable);
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
