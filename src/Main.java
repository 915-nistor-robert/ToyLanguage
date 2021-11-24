import Command.ExitCommand;
import Command.RunCommand;
import Controller.Controller;
import Model.ADT.*;
import Model.Expresions.*;
import Model.ProgramState;
import Model.Statements.*;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.RefType;
import Model.Types.StringType;
import Model.Value.BoolValue;
import Model.Value.IValue;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Repo.*;
import View.TextMenu;

import javax.management.ValueExp;


public class Main {
//    public static Repo repo = new Repo("D:\\Java projects\\A3\\repo.txt");
//    static Controller controller = new Controller(repo);
//    static View view = new View(controller);


    public static void main(String[] args) {
//        view.run();
        StackADT<IStatement> executionStack1 = new StackADT<>();
        Dictionary<String, IValue> symbolTable1 = new Dictionary<>();
        List<IValue> output1 = new List<>();
        FileTable fileTable1 = new FileTable();
        Heap<IValue> heap1 = new Heap<>();
        IStatement ex1 = new CompoundStatement(new VarDeclarationStatement("v", new IntType()),
                new CompoundStatement(new AssignStatement("v", new ValueExpression(new IntValue(10))),
                        new PrintStatement(new VarExpression("v"))));
        ProgramState programState1 = new ProgramState(executionStack1, symbolTable1, output1, ex1, fileTable1, heap1);
        Repo repo1 = new Repo("D:\\Java projects\\A3\\log1.txt");
        Controller controller1 = new Controller(repo1);
        controller1.addProgram(programState1);


        StackADT<IStatement> executionStack2 = new StackADT<>();
        Dictionary<String, IValue> symbolTable2 = new Dictionary<>();
        List<IValue> output2 = new List<>();
        FileTable fileTable2 = new FileTable();
        Heap<IValue> heap2 = new Heap<>();
        IStatement ex2 = new CompoundStatement(new VarDeclarationStatement("a", new IntType()),
                new CompoundStatement(new VarDeclarationStatement("b", new IntType()),
                        new CompoundStatement(new AssignStatement("a", new ArithmeticExpression('+', new ValueExpression(new IntValue(3)), new ArithmeticExpression('*', new ValueExpression(new IntValue(5)), new ValueExpression(new IntValue(2))))),
                                new CompoundStatement(new AssignStatement("b", new ArithmeticExpression('+', new VarExpression("a"), new ValueExpression(new IntValue(1)))), new PrintStatement(new VarExpression("b"))))));
        ProgramState programState2 = new ProgramState(executionStack2, symbolTable2, output2, ex2, fileTable2, heap2);
        Repo repo2 = new Repo("D:\\Java projects\\A3\\log2.txt");
        Controller controller2 = new Controller(repo2);
        controller2.addProgram(programState2);


        StackADT<IStatement> executionStack3 = new StackADT<>();
        Dictionary<String, IValue> symbolTable3 = new Dictionary<>();
        List<IValue> output3 = new List<>();
        FileTable fileTable3 = new FileTable();
        Heap<IValue> heap3 = new Heap<>();
        IStatement ex3 = new CompoundStatement(new VarDeclarationStatement("a", new BoolType()),
                new CompoundStatement(new VarDeclarationStatement("v", new IntType()),
                        new CompoundStatement(new AssignStatement("a", new ValueExpression(new BoolValue(true))),
                                new CompoundStatement(new IfStatement(new VarExpression("a"), new AssignStatement("v", new ValueExpression(new IntValue(1))), new AssignStatement("v", new ValueExpression(new IntValue(0)))), new PrintStatement(new VarExpression("v"))))));
        ProgramState programState3 = new ProgramState(executionStack3, symbolTable3, output3, ex3, fileTable3, heap3);
        Repo repo3 = new Repo("D:\\Java projects\\A3\\log3.txt");
        Controller controller3 = new Controller(repo3);
        controller3.addProgram(programState3);


        StackADT<IStatement> executionStack4 = new StackADT<>();
        Dictionary<String, IValue> symbolTable4 = new Dictionary<>();
        List<IValue> output4 = new List<>();
        FileTable fileTable4 = new FileTable();
        Heap<IValue> heap4 = new Heap<>();
        IStatement ex4 = new CompoundStatement(new VarDeclarationStatement("varf", new StringType()),
                new CompoundStatement(new AssignStatement("varf", new ValueExpression(new StringValue("test.in"))),
                        new CompoundStatement(new OpenRFile(new VarExpression("varf")),
                                new CompoundStatement(new VarDeclarationStatement("varc", new IntType()),
                                        new CompoundStatement(new ReadFile(new VarExpression("varf"), "varc"),
                                                new CompoundStatement(new PrintStatement(new VarExpression("varc")),
                                                        new CompoundStatement(new ReadFile(new VarExpression("varf"), "varc"),
                                                                new CompoundStatement(new PrintStatement(new VarExpression("varc")),
                                                                        new CloseRFile(new VarExpression("varf"))))))))));
        ProgramState programState4 = new ProgramState(executionStack4, symbolTable4, output4, ex4, fileTable4, heap4);
        Repo repo4 = new Repo("D:\\Java projects\\A3\\log4.txt");
        Controller controller4 = new Controller(repo4);
        controller4.addProgram(programState4);


        StackADT<IStatement> executionStack5 = new StackADT<>();
        Dictionary<String, IValue> symbolTable5 = new Dictionary<>();
        List<IValue> output5 = new List<>();
        FileTable fileTable5 = new FileTable();
        Heap<IValue> heap5 = new Heap<>();
        IStatement ex5 = new CompoundStatement(new VarDeclarationStatement("v", new IntType()),
                new CompoundStatement(new AssignStatement("v", new ValueExpression(new IntValue(4))),
                        new CompoundStatement(new WhileStatement(new RelationalExpression(">",new VarExpression("v"), new ValueExpression(new IntValue(0))),
                                new CompoundStatement(new PrintStatement(new VarExpression("v")), new AssignStatement("v", new ArithmeticExpression('-', new VarExpression("v"), new ValueExpression(new IntValue(1)))))), new PrintStatement(new VarExpression("v")))));
        ProgramState programState5 = new ProgramState(executionStack5, symbolTable5, output5, ex5, fileTable5, heap5);
        Repo repo5 = new Repo("D:\\Java projects\\A4\\log5.txt");
        Controller controller5 = new Controller(repo5);
        controller5.addProgram(programState5);

        StackADT<IStatement> executionStack6 = new StackADT<>();
        Dictionary<String, IValue> symbolTable6 = new Dictionary<>();
        List<IValue> output6 = new List<>();
        FileTable fileTable6 = new FileTable();
        Heap<IValue> heap6 = new Heap<>();
        IStatement ex6 = new CompoundStatement(new VarDeclarationStatement("v", new RefType(new IntType())),
                new CompoundStatement(new HeapAllocationStatement("v", new ValueExpression(new IntValue(20))),
                        new CompoundStatement(new PrintStatement(new ReadHeapExpression(new VarExpression("v"))),
                                new CompoundStatement(new HeapWritingStatement("v", new ValueExpression(new IntValue(30))),
                                        new PrintStatement(new ArithmeticExpression('+', new ReadHeapExpression(new VarExpression("v")), new ValueExpression(new IntValue(5))))))));

        ProgramState programState6 = new ProgramState(executionStack6, symbolTable6, output6, ex6, fileTable6, heap6);
        Repo repo6 = new Repo("D:\\Java projects\\A4\\log6.txt");
        Controller controller6 = new Controller(repo6);
        controller6.addProgram(programState6);


        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunCommand("1", ex1.toString(), controller1));
        menu.addCommand(new RunCommand("2", ex2.toString(), controller2));
        menu.addCommand(new RunCommand("3", ex3.toString(), controller3));
        menu.addCommand(new RunCommand("4", ex4.toString(), controller4));
        menu.addCommand(new RunCommand("5", ex5.toString(),controller5));
        menu.addCommand(new RunCommand("6", ex6.toString(),controller6));
        menu.show();

    }

}
