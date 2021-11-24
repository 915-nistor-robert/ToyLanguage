package Model.Value;

import Model.Types.BoolType;
import Model.Types.IType;

public class BoolValue implements IValue{
    boolean value;

    public BoolValue(){this.value = false;}

    public BoolValue(boolean i){this.value=i;}

    @Override
    public String toString(){
        return Boolean.toString(this.value);
    }

    public boolean getValue(){return this.value;}


    @Override
    public IType getType() {
        return new BoolType();
    }

    @Override
    public IValue deepCopy() {
        return new BoolValue(this.value);
    }
}
