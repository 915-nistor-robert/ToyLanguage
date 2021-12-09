package Repo;

import Model.ADT.List;
import Model.ProgramState;

public interface IRepo {
//    public ProgramState getCurrentProgram();
    List<ProgramState> getProgramList();
    void setProgramList(List<ProgramState> list);
    void addProgram(ProgramState program);
    void logProgramStateExec() throws Exception;
    //TODO custom exception for logprogramstateexec
}
