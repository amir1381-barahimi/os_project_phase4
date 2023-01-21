public class VirtualMemory {
    private Page[] virtualMemory;


    public Page[] getVirtualMemory() {
        return virtualMemory;
    }

    public void setVirtualMemory(Page[] virtualMemory) {
        this.virtualMemory = virtualMemory;
    }


    public VirtualMemory() {
        this.virtualMemory =new Page[1000];
    }
}
