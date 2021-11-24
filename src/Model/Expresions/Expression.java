package Model.Expresions;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Types.IntType;
import Model.Value.IValue;
import Model.Value.IntValue;

public abstract class Expression {
    public abstract IValue eval(IDictionary<String, IValue> symbolTable, IHeap<IValue> heap) throws Exception;
    public abstract String toString();
}
