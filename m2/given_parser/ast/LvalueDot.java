package ast;

import java.util.Hashtable;
import java.util.List;

public class LvalueDot
   implements Lvalue
{
   private final int lineNum;
   private final Expression left;
   private final String id;

   public LvalueDot(int lineNum, Expression left, String id)
   {
      this.lineNum = lineNum;
      this.left = left;
      this.id = id;
   }

   public Type checkType(Hashtable<String,Type> funcTable,
        Hashtable<String, Hashtable<String,Type>> structTable, Type retType) {
      if (left.checkType(funcTable, structTable, retType) instanceof StructType) {
         if (structTable.get(((StructType)(left.checkType(funcTable, structTable, retType))).getStructName()).get(id) == null) {
            throw new IllegalArgumentException("Id field '" + id  + "' does not exist in struct.");
         }      
      }
      else {
         throw new IllegalArgumentException("Left Expression must be of type struct.");
      }

      return structTable.get(((StructType)(left.checkType(funcTable, structTable, retType))).getStructName()).get(id);
   }

   public Value buildBlock(List<Block> allBlockList, Block curBlock, Block endBlock, Hashtable<String, Type> globalTable, Hashtable<String, Type> localTable, Hashtable<String, String> varTable, List<TypeDeclaration> types) {
      Value v = left.buildBlock(allBlockList, curBlock, endBlock, globalTable, localTable, varTable, types);
      int index = 0;
      for (int i = 0; i < types.size(); i++) {
         if (types.get(i).getTypeName().equals(v.getRegType().getName())) {
            List<Declaration> fields = types.get(i).getFields();
            for (int j = 0; j < fields.size(); j++) {
               if (fields.get(j).getDeclName().equals(id)) {
                  index = j;
               }
            }
         }
      }
      
      GetElementInstruction instr = new GetElementInstruction(v, index);
      curBlock.addInstruction(instr);
      Value v2 = instr.getReg(); 
      return v2;
   }

   public Expression getExp() {
      return left;
   }

   public String getName() {
      return ((IdentifierExpression)(left)).getId();
      //return id;
   }
}
