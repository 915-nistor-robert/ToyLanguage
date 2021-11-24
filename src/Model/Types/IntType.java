package Model.Types;

import Model.Value.IntValue;
import Model.Value.IValue;


public class IntType implements IType {
    @Override
    public IValue defaultValue() {
        return new IntValue(0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        return true;
    }


//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    @Override
    public String toString(){
        return "int";
    }

    @Override
    public IType deepCopy() {
        return null;
    }
}
