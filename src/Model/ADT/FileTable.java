package Model.ADT;

import Model.Value.StringValue;

import java.io.BufferedReader;
import java.io.File;
import java.util.Collection;

public class FileTable  implements IDictionary{
    IDictionary<StringValue, BufferedReader> fileTable;

    public FileTable(){this.fileTable = new Dictionary<StringValue, BufferedReader>();}

    private FileTable(IDictionary<StringValue, BufferedReader> fileTable){this.fileTable = fileTable;}

    public BufferedReader getReader(StringValue file_name){
        return this.fileTable.lookup(file_name);
    }




    @Override
    public void add(Object el1, Object el2) throws RuntimeException {
        this.fileTable.add((StringValue) el1,(BufferedReader) el2);
    }

    @Override
    public void update(Object el1, Object el2) {
        this.fileTable.update((StringValue) el1,(BufferedReader) el2);
    }

    @Override
    public Object lookup(Object id) {
        return this.fileTable.lookup((StringValue) id);
    }

    @Override
    public boolean isDefined(String id) {
        return this.fileTable.isDefined(id);
    }

    @Override
    public void remove(Object id) {
        this.fileTable.remove(new StringValue((String) id));
    }

    @Override
    public boolean isEmpty() {
        return this.fileTable.isEmpty();
    }

    @Override
    public Collection<BufferedReader> values() {
        return this.fileTable.values();
    }

    @Override
    public String toString() {
        return fileTable.toString();
    }
}
