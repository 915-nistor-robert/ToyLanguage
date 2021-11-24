package View;

import Controller.Controller;
import Model.ADT.*;
import Model.Expresions.ArithmeticExpression;
import Model.Expresions.ValueExpression;
import Model.Expresions.VarExpression;
import Model.ProgramState;
import Model.Statements.*;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.StringType;
import Model.Value.BoolValue;
import Model.Value.IValue;
import Model.Value.IntValue;
import Model.Value.StringValue;

import java.security.InvalidKeyException;
import java.util.Scanner;

public class View {
    Controller controller;
    private final Scanner scanner = new Scanner(System.in);

    public View(Controller controller) {
        this.controller = controller;
    }

    private void runStatement(IStatement statement) throws Exception{
        StackADT<IStatement> executionStack = new StackADT<>();
        Dictionary<String, IValue> symbolTable = new Dictionary<>();
        List<IValue> output = new List<>();
        FileTable fileTable = new FileTable();
        Heap<IValue> heap = new Heap<IValue>();
        ProgramState programState = new ProgramState(executionStack, symbolTable, output, statement, fileTable, heap);
        controller.addProgram(programState);
        try {
            controller.allStep();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        List<IValue> prints = programState.getPrintList();
        for (int i = 0; i< output.size(); i++){
            System.out.println(prints.get(i));
        }
    }

    private void firstProgram() throws Exception{
        // int v; v = 10; Print(v)
        IStatement ex1 = new CompoundStatement(new VarDeclarationStatement("v", new IntType()),
                new CompoundStatement(new AssignStatement("v", new ValueExpression(new IntValue(10))),
                        new PrintStatement(new VarExpression("v"))));
        this.runStatement(ex1);
    }

    private void secondProgram() throws Exception{
        //int a; int b; a= 3+5*2; b = a+2; Print(b);
        IStatement ex2 = new CompoundStatement(new VarDeclarationStatement("a", new IntType()),
                new CompoundStatement(new VarDeclarationStatement("b", new IntType()),
                        new CompoundStatement(new AssignStatement("a", new ArithmeticExpression('+', new ValueExpression(new IntValue(3)), new ArithmeticExpression('*', new ValueExpression(new IntValue(5)), new ValueExpression(new IntValue(2))))),
                                new CompoundStatement(new AssignStatement("b", new ArithmeticExpression('+', new VarExpression("a"), new ValueExpression(new IntValue(1)))), new PrintStatement(new VarExpression("b"))))));
        this.runStatement(ex2);
    }

    private void thirdProgram() throws Exception{
        // int a; int v; a = true; (If a then v = 1 else v = 0); Print(v);
        IStatement ex3 = new CompoundStatement(new VarDeclarationStatement("a", new BoolType()),
                new CompoundStatement(new VarDeclarationStatement("v", new IntType()),
                        new CompoundStatement(new AssignStatement("a", new ValueExpression(new BoolValue(true))),
                                new CompoundStatement(new IfStatement(new VarExpression("a"),new AssignStatement("v", new ValueExpression(new IntValue(1))), new AssignStatement("v", new ValueExpression(new IntValue(0)))), new PrintStatement(new VarExpression("v"))))));
        this.runStatement(ex3);
    }

    private void fourthProgram() throws Exception{
        IStatement ex4 = new CompoundStatement(new VarDeclarationStatement("varf",new StringType()),
                new CompoundStatement(new AssignStatement("varf",new ValueExpression(new StringValue("test.in"))),
                        new CompoundStatement(new OpenRFile(new VarExpression("varf")),
                                new CompoundStatement(new VarDeclarationStatement("varc",new IntType()),
                                        new CompoundStatement(new ReadFile(new VarExpression("varf"),"varc"),
                                                new CompoundStatement(new PrintStatement(new VarExpression("varc")),
                                                        new CompoundStatement(new ReadFile(new VarExpression("varf"),"varc"),
                                                                new CompoundStatement(new PrintStatement(new VarExpression("varc")),
                                                                        new CloseRFile(new VarExpression("varf"))))))))));
        runStatement(ex4);
    }

    public void run(){
        boolean running = true;
        while (running){
            System.out.println("Please choose one of the predefined actions:");
            System.out.println("1. int v; v = 10; Print(v)");
            System.out.println("2. int a; int b; a= 3+5*2; b = a+2; Print(b);");
            System.out.println("3. int a; int v; a = true; (If a then v = 1 else v = 0); Print(v);");
            String option = this.scanner.nextLine();
            try {
                switch (option.trim()){
                    case "1":
                        this.firstProgram();
                        running = false;
                        break;
                    case "2":
                        this.secondProgram();
                        running = false;
                        break;
                    case "3":
                        this.thirdProgram();
                        running = false;
                        break;
                    case "4":
                        this.fourthProgram();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid action!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
