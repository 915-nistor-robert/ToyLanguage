package Model.Statements;

import Model.ADT.Dictionary;
import Model.ADT.Heap;
import Model.ADT.IStack;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Types.BoolType;
import Model.Value.BoolValue;
import Model.Value.IValue;

public class WhileStatement implements IStatement{
    private Expression expression;
    private IStatement statement;

    public WhileStatement(Expression expression, IStatement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        Dictionary<String, IValue> symbolTable = state.getSymbolTable();
        Heap<IValue> heap = state.getHeap();
        IStack<IStatement> executionStack = state.getExecutionStack();

        IValue expressionValue = this.expression.eval(symbolTable,heap);
        if (!(expressionValue.getType().equals(new BoolType()))){
            throw new Exception("Expression value not a BoolType!");
        }

        BoolValue condition = (BoolValue) expressionValue;

        if (condition.getValue()){
            executionStack.push(new WhileStatement(expression,statement));
            executionStack.push(statement);
        }
        return state;
    }

    @Override
    public String toString() {
        return "(while(" + expression +
                ") " + statement +
                ')';
    }
}
