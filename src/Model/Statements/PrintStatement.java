package Model.Statements;

import Model.ADT.List;
import Model.Expresions.Expression;
import Model.ProgramState;
import Model.Value.IValue;

public class PrintStatement implements IStatement{
    Expression expression;

    public PrintStatement(Expression expression){this.expression = expression;}

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        List<IValue> printList = state.getPrintList();
        printList.add(expression.eval(state.getSymbolTable(),state.getHeap()));
        state.setPrintList(printList);
        return state;
    }

    public String toString(){return "print(" + this.expression + ")";}
}
