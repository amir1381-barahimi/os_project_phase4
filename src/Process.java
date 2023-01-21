import java.util.ArrayList;

public class Process {
    private String name_process;
    private ArrayList<ProcessVariable> vars_process;

    public Process(String name_process, ArrayList<ProcessVariable> vars_process) {
        this.name_process = name_process;
        this.vars_process = vars_process;
    }

    public String getName_process() {
        return name_process;
    }

    public void setName_process(String name_process) {
        this.name_process = name_process;
    }

    public ArrayList<ProcessVariable> getVars_process() {
        return vars_process;
    }

    public void setVars_process(ArrayList<ProcessVariable> vars_process) {
        this.vars_process = vars_process;
    }

}
