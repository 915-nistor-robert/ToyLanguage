package Model.Expresions;

import Exceptions.DivisionByZeroException;
import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Types.IntType;
import Model.Value.IValue;
import Model.Value.IntValue;

public class ArithmeticExpression extends Expression {
    private char operand;
    private Expression e1, e2;

    public ArithmeticExpression(char op, Expression e1, Expression e2) {
        this.operand = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public IValue eval(IDictionary<String, IValue> symbolTable,  IHeap<IValue> heap) throws Exception {
        IValue first_value = e1.eval(symbolTable,heap);
        IValue second_value = e2.eval(symbolTable,heap);

        if (!first_value.getType().equals(new IntType()) && !second_value.getType().equals(new IntType())) {
            throw new RuntimeException("the values need to be IntType");
        }

        int number1 = ((IntValue) first_value).getValue();

        int number2 = ((IntValue) second_value).getValue();

        switch (operand) {
            case '+':
                return new IntValue(number1 + number2);
            case '-':
                return new IntValue(number1 - number2);
            case '/':
                if (number2 == 0) {
                    throw new DivisionByZeroException("Cannot divide by 0!");
                    //throw new DivisionByZeroException("Cannot divide by 0!!");
                } else {
                    return new IntValue(number1 / number2);
                }
            case '*':
                return new IntValue(number1 * number2);
            default:
                throw new RuntimeException("The operator is not valid");
        }
    }

    public char getOperand() {
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
