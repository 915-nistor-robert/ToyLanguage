package Model;

import Model.ADT.*;

import Model.Statements.IStatement;
import Model.Value.IValue;
import Model.Value.StringValue;

import java.io.BufferedReader;

public class ProgramState {
    StackADT<IStatement> executionStack;
    Dictionary<String, IValue> symbolTable;
    List<IValue> printList;
    IStatement originalProgram;
    FileTable fileTable;
    Heap<IValue> heap;

    public ProgramState(StackADT<IStatement> executionStack, Dictionary<String, IValue> symbolTable, List<IValue> printList, IStatement originalProgram, FileTable FileTable, Heap<IValue> heap) {
        this.executionStack = executionStack;
        this.symbolTable = symbolTable;
        this.printList = printList;
        this.originalProgram = originalProgram;
        this.fileTable = FileTable;
        this.heap = heap;
    }


    @Override
    public String toString() {
//        return "ProgramState{" +
//                "executionStack=" + executionStack +
//                ", symbolTable=" + symbolTable +
//                ", printList=" + printList +
//                '}';
        return "___________________________________\n" +
                "ProgramState:\n"+"Execution Stack = "+executionStack+"\nSymbol Table = "+ symbolTable+"\nPrint List = "+printList+ "\nFile Table="+fileTable +"\nHeap ="+heap +"\n___________________________________";
    }

    public List<IValue> getPrintList() {
        return printList;
    }

    public IStatement getOriginalProgram() {
        return originalProgram;
    }

    public StackADT<IStatement> getExecutionStack() {
        return executionStack;
    }

    public FileTable getFileTable(){return this.fileTable;}

    public Heap<IValue> getHeap(){return this.heap;}

    public Dictionary<String, IValue> getSymbolTable() {
        return symbolTable;
    }

    public void setExecutionStack(StackADT<IStatement> executionStack) {
        this.executionStack = executionStack;
    }

    public void setSymbolTable(Dictionary<String, IValue> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public void setPrintList(List<IValue> printList) {
        this.printList = printList;
    }

    public void setFileTable(FileTable fileTable){this.fileTable = fileTable;}

    public void setHeap(Heap<IValue> heap) {
        this.heap = heap;
    }

    public void setOriginalProgram(IStatement originalProgram) {
        this.originalProgram = originalProgram;
    }
}
