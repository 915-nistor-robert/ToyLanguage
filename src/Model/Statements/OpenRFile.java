package Model.Statements;

import Model.ADT.FileTable;
import Model.ADT.Heap;
import Model.ADT.IDictionary;
import Model.ADT.IStack;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Types.StringType;
import Model.Value.IValue;
import Model.Value.StringValue;

import java.io.BufferedReader;
import java.io.FileReader;

public class OpenRFile implements IStatement{
    Expression expression;

    public OpenRFile(Expression expression){
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        IStack<IStatement> executionStack = state.getExecutionStack();
        IDictionary<String, IValue> symbolTable = state.getSymbolTable();
        Heap<IValue> heap = state.getHeap();
     // TODO what is filePath?
//        StringValue filePath = this.expression.eval(symbolTable).getValue();

        IValue expressionValue = this.expression.eval(symbolTable,heap);
        FileTable fileTable = state.getFileTable();

        StringType str = new StringType();

        if (str.getClass().equals(expressionValue.getType().getClass())){
            StringValue expressionValue_string = (StringValue) this.expression.eval(symbolTable,heap);
            String filePath = expressionValue_string.getValue().toString();
            if (fileTable.isDefined(filePath)){
                throw new Exception("This value already exists");
            }

            FileReader in = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(in);
            StringValue filePath_string = new StringValue(filePath);
            fileTable.add(filePath_string, reader);
        }
        else {
            throw new Exception("Not a string for file reading");
        }
        System.out.println("file added");
        return state;

    }

    public String toString(){
        return "openRFile("+ expression.toString() + ")";
    }
}
