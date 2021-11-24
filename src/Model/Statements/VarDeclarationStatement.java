package Model.Statements;

import Exceptions.VariableAlreadyDeclaredException;
import Model.ADT.Dictionary;
import Model.ProgramState;
import Model.Types.IType;
import Model.Value.IValue;

public class VarDeclarationStatement implements IStatement{
    String name;
    IType type;
    public VarDeclarationStatement(String name, IType type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString(){
        return this.type + " " + this.name;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        Dictionary<String, IValue> symbolTable =  state.getSymbolTable();
        if (symbolTable.isDefined(this.name)){
            throw new VariableAlreadyDeclaredException("this variable already exists");
        }
        symbolTable.add(this.name, this.type.defaultValue());
        return state;
    }
}
