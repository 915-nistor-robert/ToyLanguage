package Model.Expresions;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Types.IntType;
import Model.Value.BoolValue;
import Model.Value.IValue;
import Model.Value.IntValue;

public class RelationalExpression extends Expression {
    private final String operator;
    private final Expression expression1;
    private final Expression expression2;

    public RelationalExpression(String operator, Expression expression1, Expression expression2) {
        this.operator = operator;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public IValue eval(IDictionary<String, IValue> symbolTable, IHeap<IValue> heap) throws Exception {
        IValue firstValue = expression1.eval(symbolTable, heap);
        IValue secondValue = expression2.eval(symbolTable, heap);

//        IntValue integer = new IntValue();

        if (!firstValue.getType().equals(new IntType()) || !secondValue.getType().equals(new IntType())) {
            throw new Exception("The values needs to be IntValue!");
        } else {
            BoolValue solution;
            IntValue firstValueInt = (IntValue) this.expression1.eval(symbolTable, heap);
            IntValue secondValueInt = (IntValue) this.expression2.eval(symbolTable, heap);
            switch (operator) {
                case ">" -> solution = new BoolValue(firstValueInt.getValue() > secondValueInt.getValue());
                case ">=" -> solution = new BoolValue(firstValueInt.getValue() >= secondValueInt.getValue());
                case "<" -> solution = new BoolValue(firstValueInt.getValue() < secondValueInt.getValue());
                case "<=" -> solution = new BoolValue(firstValueInt.getValue() <= secondValueInt.getValue());
                case "==" -> solution = new BoolValue(firstValueInt.getValue() == secondValueInt.getValue());
                case "!=" -> solution = new BoolValue(firstValueInt.getValue() != secondValueInt.getValue());
                default -> throw new RuntimeException("Invalid operator ->" + this.operator);
            }
            return solution;
        }
    }

    @Override
    public String toString() {
        return "" + expression1 + operator + expression2;
    }
}
