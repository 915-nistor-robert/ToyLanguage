package Model.ADT;

public interface IStack<T> {
    T pop();
    void push(T element);
    boolean isEmpty();
    String toString();
}
