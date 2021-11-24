package Model.ADT;
import java.security.PublicKey;
import java.util.Stack;

public class List <T> implements IList<T>{
    Stack<T> list;

    public List(){this.list = new Stack<>();}

    @Override
    public void add(int pos, T element) throws RuntimeException {
        this.list.add(pos, element);
    }

    public void add(T element){
        this.list.add(element);
    }

    public T getFirstElement(){return this.list.peek();}

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public T get(int pos) {
        return this.list.get(pos);
    }

    @Override
    public void remove(int pos) {
        this.list.remove(pos);
    }

    @Override
    public String toString(){
        return this.list.toString();
    }
}
