package Model.Statements;

import Model.ADT.StackADT;
import Model.Expresions.Expression;
import Model.ProgramState;

public class CompoundStatement implements IStatement{
    IStatement e1;
    IStatement e2;

    public CompoundStatement(IStatement e1, IStatement e2){
        this.e1 = e1;
        this.e2 = e2;
    }


    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        StackADT<IStatement> execStack = state.getExecutionStack();
        execStack.push(e2);
        execStack.push(e1);

        state.setExecutionStack(execStack);
        return state;
    }

    public String toString(){return this.e1 +";"+this.e2;}
}
