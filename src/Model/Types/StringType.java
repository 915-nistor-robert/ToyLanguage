package Model.Types;

import Model.Value.IValue;
import Model.Value.StringValue;

public class StringType implements IType{
    @Override
    public IValue defaultValue() {
        return new StringValue("");
    }

    @Override
    public String toString(){
        return "string";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        return true;
    }

    @Override
    public IType deepCopy() {
        return null;
    }
}
