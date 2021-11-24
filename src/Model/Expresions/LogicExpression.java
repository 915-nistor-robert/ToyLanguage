package Model.Expresions;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Value.BoolValue;
import Model.Value.IValue;

public class LogicExpression extends Expression {
    private String operand;
    private Expression e1, e2;

    public LogicExpression(String operand, Expression e1, Expression e2) {
        this.operand = operand;
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public IValue eval(IDictionary<String, IValue> symbolTable, IHeap<IValue> heap) throws Exception {
        IValue first_value = e1.eval(symbolTable, heap);
        IValue second_value = e2.eval(symbolTable, heap);

        if (!first_value.getType().equals(new BoolType()) && !second_value.getType().equals(new BoolType())) {
            throw new RuntimeException("need to be bool");
        }
        boolean bool1 = ((BoolValue) first_value).getValue();
        boolean bool2 = ((BoolValue) second_value).getValue();

        switch (operand) {
            case "and":
                return new BoolValue(bool1 && bool2);
            case "or":
                return new BoolValue(bool1 || bool2);
            default:
                throw new RuntimeException("The operator is not valid");
        }
    }

    public String getOp() {
        return this.operand;
    }

    public Expression getFirst() {
        return this.e1;
    }

    public Expression getSecond() {
        return this.e2;
    }


    @Override
    public String toString() {
        return e1.toString() + " " + operand + " " + e2.toString();
    }
}
