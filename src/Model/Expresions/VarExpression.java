package Model.Expresions;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Types.IntType;
import Model.Value.IValue;

public class VarExpression extends Expression {
    String id;

    public VarExpression(String id){
        this.id = id;
    }

    @Override
    public IValue eval(IDictionary<String, IValue> symbolTable, IHeap<IValue> heap) throws RuntimeException {
        return (IValue) symbolTable.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
