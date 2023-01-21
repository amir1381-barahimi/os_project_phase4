public class VirtualMemory {
    private Page[] virtualMemory;

    public VirtualMemory() {
        virtualMemory = new Page[1000];

        for (int i = 0; i < 1000; i++) {
            virtualMemory[i] = new Page();
        }
    }

    public Page[] getVirtualMemory() {
        return virtualMemory;
    }

    public void setVirtualMemory(Page[] virtualMemory) {
        this.virtualMemory = virtualMemory;
    }
}
