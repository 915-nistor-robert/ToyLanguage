package Model.Statements;

import Model.ADT.Dictionary;
import Model.ADT.Heap;
import Model.ADT.StackADT;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Types.BoolType;
import Model.Value.BoolValue;
import Model.Value.IValue;
import com.sun.jdi.InvalidTypeException;

public class IfStatement implements IStatement{
    Expression expression;
    IStatement thenStatement;
    IStatement elseStatement;

    public IfStatement(Expression expression, IStatement statement1, IStatement statement2){
        this.expression = expression;
        this.thenStatement = statement1;
        this.elseStatement = statement2;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        Dictionary<String, IValue> symbolTable = state.getSymbolTable();
        StackADT<IStatement> executionStack = state.getExecutionStack();
        Heap<IValue> heap = state.getHeap();
        IValue conditionValue = this.expression.eval(symbolTable,heap);
        if (!conditionValue.getType().equals(new BoolType())){
            throw new InvalidTypeException();
        }
        BoolValue condition = (BoolValue) conditionValue;
        if (condition.getValue()){
            executionStack.push(this.thenStatement);
        } else{
            executionStack.push(this.elseStatement);
        }
        state.setExecutionStack(executionStack);
        return state;
    }

    @Override
    public String toString() {
        return "If(" + expression +
                "), then " + thenStatement +
                ", else " + elseStatement ;
    }
}
