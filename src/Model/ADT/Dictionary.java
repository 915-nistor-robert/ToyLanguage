package Model.ADT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Dictionary<T1, T2> implements IDictionary<T1,T2>{
    Map<T1, T2> dictionary;

    public Dictionary(){dictionary = new HashMap<T1,T2>();
    }

    @Override
    public String toString() {
        return dictionary.toString();
    }

    @Override
    public void add(T1 el1, T2 el2) throws RuntimeException {
        try{
            dictionary.put(el1, el2);
        }
        catch (RuntimeException e){
            throw new RuntimeException("Can't add null value");
        }
    }

    @Override
    public void update(T1 el1, T2 el2) {
        dictionary.replace(el1, el2);
        //TODO: key not found
    }

    @Override
    public T2 lookup(T1 id) {
        return dictionary.get(id);
    }

    @Override
    public boolean isDefined(String id) {
        return dictionary.containsKey(id);
    }

    @Override
    public void remove(T1 id) {
        this.dictionary.remove(id);
        //TODO: key not found
    }

    @Override
    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    @Override
    public Collection<T2> values() {
        return this.dictionary.values();
    }
}
