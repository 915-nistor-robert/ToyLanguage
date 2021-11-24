package Model.ADT;

import Model.Value.IValue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Heap<T> implements IHeap<T> {
    private Map<Integer, T> heap;
    private int nextAddress;

    public Heap(){
        this.heap = new HashMap<Integer, T>();
        this.nextAddress = 1;
    }

    @Override
    public String toString() {
        return this.heap.toString();
    }

    @Override
    public int getFreeLocation() {
        return 0;
    }

    @Override
    public T lookup(int address) {
        return this.heap.get(address);
    }

    @Override
    public int add(T value) {
        int allocatedPosition = this.getFreeLocation();
        heap.put(allocatedPosition, value);
        this.nextAddress += 1;
        return allocatedPosition;
    }

    @Override
    public void setContent(Map<Integer,T> newContent) {
        this.heap = newContent;
    }

    @Override
    public void update(int address, T value) {
        this.heap.replace(address, value);
    }


    @Override
    public boolean isDefined(int address) {
        return this.heap.containsKey(address);
    }

    @Override
    public IHeap<T> clone() {
        return null;
    }

    @Override
    public Collection<T> values() {
        return this.heap.values();
    }

    @Override
    public void remove(int key) {
        this.heap.remove(key);
    }

    public Collection<Integer> keys(){
        return this.heap.keySet();
    }


    //____________________________________________
//    private final Map<Integer, T> heapTable;
//    private final int nextAddress = 1;
//    int freeAddress = 1;
//
//    public Heap(){
//        this.heapTable = new HashMap<Integer,T>();
//    }
//
//    @Override
//    public T lookup(Integer address) {
//        return heapTable.get(address);
//    }
//
////    @Override
////    public IValue lookup(String symbolName) {
////        return heapTable.get(symbolName);
////    }
//
//    @Override
//    public Map getHeap() {
//        return this.heapTable;
//    }
//
////    @Override
////    public Object getValue(int id) {
////        return null;
////    }
//
//    @Override
//    public Pair<Heap, Integer> allocate(IValue value) {
////        Integer addr = nextAddress.getAndIncreme;
//        return null;
//    }
//
//    @Override
//    public int getFreeLocation() {
//        return 0;
//    }
//
////    @Override
////    public void add(Object value) {
////
////    }
//
//    @Override
//    public void add(T value) {
//        this.heapTable.put(freeAddress++, value);
//    }
//
//    @Override
//    public void update(int key, T value) {
//        this.heapTable.replace(key, value);
//    }
//
//    @Override
//    public void remove(int key) {
//
//    }
//

}
