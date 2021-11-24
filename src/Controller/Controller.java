package Controller;

import Model.ADT.*;
import Model.ProgramState;
import Model.Statements.IStatement;
import Model.Value.IValue;
import Model.Value.RefValue;
import Repo.Repo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Controller {
    Repo repo;

    public Controller(Repo repo) {
        this.repo = repo;
    }

    public void addProgram(ProgramState program) {
        StackADT<IStatement> execStack = new StackADT<>();
        execStack.push(program.getOriginalProgram());
        program.setExecutionStack(execStack);

        this.repo.addProgram(program);
    }

    public ProgramState oneStep(ProgramState state) throws Exception {
        StackADT<IStatement> stack = state.getExecutionStack();
        if (stack.isEmpty()) {
            throw new Exception("Execution Stack is empty");
        } else {
            IStatement currentStatement = stack.pop();
            return currentStatement.execute(state);
        }
    }


    public void garbageCollector(ProgramState state) {
        Heap<IValue> heap = state.getHeap();
        ArrayList<Integer> used = new ArrayList<Integer>();

        for (IValue value : state.getSymbolTable().values()) {
            while (value instanceof RefValue) {
                int usedAddress = ((RefValue) value).getAddress();
                if (!heap.isDefined(usedAddress)) {
                    break;
                }
                used.add(usedAddress);
                value = heap.lookup(usedAddress);
            }
        }
        Set<Integer> notUsed = new HashSet<>();

        for (int address: state.getHeap().keys()){
            if (!used.contains(address)){
                notUsed.add(address);
            }
        }

        for (int address : notUsed){
            heap.remove(address);
        }
    }


    public void allStep() throws Exception {
        ProgramState program = this.repo.getCurrentProgram();
        repo.logProgramStateExec();
        System.out.println(program.toString());
        while (!program.getExecutionStack().isEmpty()) {
            oneStep(program);
            repo.logProgramStateExec();
            garbageCollector(program);
            System.out.println(program.toString());
        }
    }
}
