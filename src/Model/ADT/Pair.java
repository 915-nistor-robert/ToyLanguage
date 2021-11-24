package Model.ADT;

public class Pair<T1,T2> implements IPair{
    private T1 firstElement;
    private T2 secondElement;

    public Pair(T1 firstElement, T2 secondElement){
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }


    @Override
    public Object getFirstElement() {
        return this.firstElement;
    }

    @Override
    public Object getSecondElement() {
        return this.secondElement;
    }
}
