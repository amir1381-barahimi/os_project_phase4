public class MainMemory {
    public static Page[] mainMemory;

    public static int freeStorage;





    public MainMemory() {
        this.mainMemory =new Page[10];
        this.freeStorage=4000;
    }
}
