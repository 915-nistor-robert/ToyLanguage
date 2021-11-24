package Repo;

import Model.ADT.IStack;
import Model.ADT.List;
import Model.ProgramState;
import Model.Statements.IStatement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Repo implements IRepo {

    List<ProgramState> repo;
    private String logFilePath;
    private boolean firstFileCall;


    public Repo(String logFilePath) {
        this.repo = new List<ProgramState>();
        this.logFilePath = logFilePath;
    }


    @Override
    public ProgramState getCurrentProgram() {
        if (this.repo.size() == 0) {
            throw new RuntimeException("");
        }
        return this.repo.get(0);
    }

    @Override
    public void addProgram(ProgramState program) {
        this.repo.add(program);
    }

    public void clearFile() throws IOException{
        PrintWriter logFile;
        logFile = new PrintWriter(new FileWriter(logFilePath));
        logFile.close();

    }

    @Override
    public void logProgramStateExec() throws Exception {
       //TODO for each not working??
        try{
            if (this.firstFileCall){
                PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, false)));
                logFile.write("");
                logFile.close();
                this.firstFileCall = false;
            }
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            System.out.println(this.repo.get(0).toString());
            logFile.write(this.repo.get(0).toString() + "\n");
            logFile.close();
        } catch (IOException e){
            e.getStackTrace();
        }
        }





}
