package Repo;

import Model.ProgramState;

public interface IRepo {
    public ProgramState getCurrentProgram();
    void addProgram(ProgramState program);
    void logProgramStateExec() throws Exception;
    //TODO custom exception for logprogramstateexec
}
