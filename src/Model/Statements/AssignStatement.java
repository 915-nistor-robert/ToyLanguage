package Model.Statements;

import Exceptions.UndeclaredVariableException;
import Model.ADT.Dictionary;
import Model.ADT.Heap;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Value.IValue;
import com.sun.jdi.InvalidTypeException;

import java.security.InvalidKeyException;

public class AssignStatement implements IStatement{
    String variableName;
    Expression expression;

    public AssignStatement(String variableName, Expression expression){
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        Dictionary<String, IValue> symbolTable = state.getSymbolTable();
        Heap<IValue> heap = state.getHeap();
        if (symbolTable.isDefined(variableName)){
            IValue value = this.expression.eval(symbolTable,heap);
            if (value.getType().equals(symbolTable.lookup(variableName).getType())){
                symbolTable.update(variableName,value);
            }
            else
                throw new InvalidTypeException();

        } else
            throw new UndeclaredVariableException("Undefined variable!");
        state.setSymbolTable(symbolTable);
        return state;

    }

    public String toString(){return variableName + "=" + this.expression;}
}
