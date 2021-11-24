package Model.Statements;

import Model.ADT.Dictionary;
import Model.ADT.Heap;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Value.IValue;
import Model.Value.RefValue;

public class HeapWritingStatement implements IStatement{
    String var_name;
    Expression expression;

    public HeapWritingStatement(String var_name, Expression expression) {
        this.var_name = var_name;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        Dictionary<String, IValue> symbolTable = state.getSymbolTable();
        Heap<IValue> heap = state.getHeap();

        if (!symbolTable.isDefined(var_name)){
            throw new Exception("Variable not declared!");
        }

        IValue value = symbolTable.lookup(var_name);
        if (!(value instanceof RefValue)){
            throw new Exception("Not a Reference Type!");
        }
        int address = ((RefValue)value).getAddress();
        if (!(heap.isDefined(address))){
            throw new Exception("Address not found in heap!");
        }

        IValue expressionValue = expression.eval(symbolTable,heap);

        if (!expressionValue.getType().equals(((RefValue) value).getLocationType())){
            throw new Exception("Different type exception!");
        }
        heap.update(address, expressionValue);
        state.setHeap(heap);
        //TODO: why is set heap not necessary
        return state;

    }

    @Override
    public String toString() {
        return "HeapWritingStatement(" + this.var_name + "," +this.expression+")";
    }
}
