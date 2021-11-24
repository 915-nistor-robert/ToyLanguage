package Model.Statements;

import Model.ADT.Dictionary;
import Model.ADT.Heap;
import Model.ADT.IDictionary;
import Model.ADT.IStack;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Types.IntType;
import Model.Value.IValue;
import Model.Value.IntValue;
import Model.Value.StringValue;

import java.io.BufferedReader;

public class ReadFile implements IStatement {
    Expression expression;
    String var_name;

    public ReadFile(Expression expression, String var_name) {
        this.var_name = var_name;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        IStack<IStatement> executionStack = state.getExecutionStack();
        Dictionary<String, IValue> symbolTable = state.getSymbolTable();
        Heap<IValue> heap = state.getHeap();
        StringValue filename = new StringValue(this.expression.eval(symbolTable,heap).toString());
        BufferedReader reader = state.getFileTable().getReader(filename);
        int fileValue;
        try {
            fileValue = Integer.parseInt(reader.readLine());
            symbolTable.add(var_name, new IntValue(fileValue));
        } catch (Exception e) {
            fileValue = 0;
        }

        state.setSymbolTable(symbolTable);
        return state;

    }

    @Override
    public String toString() {
        return "ReadFile{" + expression.toString() +
                "," + var_name + '\'' +
                '}';
    }
}
