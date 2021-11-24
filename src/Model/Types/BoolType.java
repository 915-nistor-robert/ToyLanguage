package Model.Types;

import Model.Value.BoolValue;
import Model.Value.IValue;

public class BoolType implements IType{
    @Override
    public IValue defaultValue() {
        return new BoolValue(false);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        return true;
    }

    @Override
    public IType deepCopy() {
        return new BoolType();
    }

    @Override
    public String toString(){
        return "boolean";
    }
}
