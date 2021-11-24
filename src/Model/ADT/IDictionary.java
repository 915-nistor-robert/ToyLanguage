package Model.ADT;

import java.util.Collection;

public interface IDictionary<T1,T2> {

    void add(T1 el1 , T2 el2) throws RuntimeException;
    void update(T1 el1, T2 el2);
    T2 lookup(T1 id);
    boolean isDefined(String id);
    String toString();
    void remove(T1 id);
    boolean isEmpty();
    Collection<T2> values();
}
