public class MainMemory {
    private Page[] mainMemory;

    public MainMemory() {
        mainMemory = new Page[10];
        for (int i = 0; i < 10; i++) {
            mainMemory[i] = new Page();
        }
    }

    int findMinimumAccess() {
        int minAccess = Integer.MAX_VALUE;

        int index = 0;
        for (int i = 0; i < mainMemory.length; i++) {
            if (mainMemory[i].getAccessTime() < minAccess) {
                index = i;
            }
        }

        return index;
    }

    public Page[] getMainMemory() {
        return mainMemory;
    }

    public void setMainMemory(Page[] mainMemory) {
        this.mainMemory = mainMemory;
    }
}
