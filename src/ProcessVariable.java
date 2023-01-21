public class ProcessVariable {
    private String variable_name;
    private int memory_require;


    public ProcessVariable(String variable_name, int memory_require) {
        this.variable_name = variable_name;
        this.memory_require = memory_require;
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
}
