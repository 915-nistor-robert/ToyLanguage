package Model.Statements;

import Model.ADT.*;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Value.IValue;
import Model.Value.RefValue;

public class HeapAllocationStatement implements IStatement {
    String var_name;
    Expression expression;

    public HeapAllocationStatement(String var_name, Expression expression) {
        this.var_name = var_name;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        Dictionary<String , IValue> symbolTable = state.getSymbolTable();
        Heap<IValue> heap = state.getHeap();
        if (!symbolTable.isDefined(var_name)){
            throw new Exception("Variable not defined");
        }
        IValue value = symbolTable.lookup(var_name);
        if (!(value instanceof RefValue)){
            throw new Exception("Not a Reference Type");
                    //TODO Custom exceptions
        }
        IValue expressionValue = this.expression.eval(symbolTable, heap);
        if (!expressionValue.getType().equals(((RefValue) value).getLocationType())){
            throw new Exception("Different type exception!");
        }
        int allocatedPosition = heap.add(expressionValue);
        RefValue updatedRefValue = new RefValue(allocatedPosition, ((RefValue)value).getLocationType());
        symbolTable.update(var_name, updatedRefValue);
        state.setHeap(heap);
        state.setSymbolTable(symbolTable);
        return state;
    }

    public IStatement deepcopy(){
        return new HeapAllocationStatement(var_name, expression);
    }

    @Override
    public String toString() {
        return "new HeapAllocStmn(" + var_name +","+expression+")";
    }
}
