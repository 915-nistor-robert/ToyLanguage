package Model.Statements;

import Model.ADT.IDictionary;
import Model.ProgramState;
import Model.Value.IValue;

public interface IStatement {
    public ProgramState execute(ProgramState state) throws Exception;
    public String toString();
}
