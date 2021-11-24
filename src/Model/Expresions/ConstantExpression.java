package Model.Expresions;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Types.IntType;
import Model.Value.IValue;
import Model.Value.IntValue;

public class ConstantExpression extends Expression {
    IntValue value;

    public ConstantExpression(IntValue value){this.value = value;}

    @Override
    public IValue eval(IDictionary<String, IValue> symbolTable, IHeap<IValue> heap) {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
