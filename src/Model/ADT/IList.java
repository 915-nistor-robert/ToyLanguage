package Model.ADT;

public interface IList<T> {
    void add(int pos, T element) throws RuntimeException;
    String toString();
    boolean isEmpty();
    void clear();
    int size();
    T get(int pos);
    void remove(int pos);
}
