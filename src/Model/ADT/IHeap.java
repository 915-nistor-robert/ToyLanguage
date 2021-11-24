package Model.ADT;

import Model.Value.IValue;

import java.util.Collection;
import java.util.Map;

public interface IHeap<T> {

    int getFreeLocation();

    T lookup(int address);

    int add(T value);

    void update(int address, T value);

    boolean isDefined(int address);

    IHeap<T> clone();

    public Collection<T> values();

//    T lookup(Integer address);
//
////    IValue lookup(String symbolName);
//
//    Map<Integer, T> getHeap();
//
////    T getValue(int id);
//
//    Pair<Heap, Integer> allocate(IValue value);
//
//    int getFreeLocation();
//
//    void add(T value);
//
//    void update(int key, T value);
//
    void remove(int key);
//
    void setContent(Map<Integer, T> newContent);
}
