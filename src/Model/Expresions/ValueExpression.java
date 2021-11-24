package Model.Expresions;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Value.IValue;

public class ValueExpression extends Expression{
    IValue value;

    public ValueExpression(IValue value){this.value = value;}

    @Override
    public IValue eval(IDictionary<String, IValue> symbolTable, IHeap<IValue> heap) throws RuntimeException {
        return value;
    }

    @Override
    public String toString() {
        return ""+this.value;
    }
}
