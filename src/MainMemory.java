public class MainMemory {
    private Page[] mainMemory;

    public static int freeStorage;




    public Page[] getMainMemory() {
        return mainMemory;
    }

    public void setMainMemory(Page[] mainMemory) {
        this.mainMemory = mainMemory;
    }


    public MainMemory() {
        this.mainMemory =new Page[10];
        this.freeStorage=4000;
    }
}
