public class ProcessVariable {
    private String variable_name;
    private int memory_require;
    private String process_name;

    public ProcessVariable(String variable_name, int memory_require, String process_name) {
        this.variable_name = variable_name;
        this.memory_require = memory_require;
        this.process_name = process_name;
    }

    public String getValue() {
        return variable_name;
    }

    public void setValue(String value) {
        this.variable_name = value;
    }

    public int getMemory_require() {
        return memory_require;
    }

    public void setMemory_require(int memory_require) {
        this.memory_require = memory_require;
    }

    public String getVariable_name() {
        return variable_name;
    }

    public void setVariable_name(String variable_name) {
        this.variable_name = variable_name;
    }

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }
}
