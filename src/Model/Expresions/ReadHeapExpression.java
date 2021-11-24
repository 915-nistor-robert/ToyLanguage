package Model.Expresions;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Value.IValue;
import Model.Value.RefValue;

public class ReadHeapExpression extends Expression {
    Expression expression;

    public ReadHeapExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public IValue eval(IDictionary<String, IValue> symbolTable, IHeap<IValue> heap) throws Exception {
        IValue expressionValue = expression.eval(symbolTable, heap);

        if (!(expressionValue instanceof RefValue)){
            throw new Exception("Not a Reference Type!");
        }
        int address = ((RefValue) expressionValue).getAddress();
        if (!(heap.isDefined(address))){
            throw new Exception("This address is not defined!");
        }
        return heap.lookup(address);
    }

    @Override
    public String toString() {
        return "ReadHeap(" +this.expression +")";
    }
}
