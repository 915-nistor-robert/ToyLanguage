package Model.Value;

import Model.Types.IType;
import Model.Types.StringType;

import java.util.Objects;

public class StringValue implements IValue{
    String value;

    public StringValue(){this.value = "";}

    public StringValue(String value){this.value = value;}

//    @Override

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValue that = (StringValue) o;
        return Objects.equals(value, that.value);
    }


//    public boolean equals(Object o){
//        if(o == null || o.getClass() != this.getClass())
//            return false;
//        StringValue o_value = (StringValue) o;
//        return o_value.value.equals(this.value);
//    }

    @Override
    public IType getType() {
        return new StringType();
    }

    public String getValue(){return this.value;}

    @Override
    public IValue deepCopy() {
        return new StringValue(this.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
