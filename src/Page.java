

public class Page {
    private ProcessVariable[] page;
    private int freeStorage;


    public int getFreeStorage() {
        return freeStorage;
    }

    public void setFreeStorage(int freeStorage) {
        this.freeStorage = freeStorage;
    }


    public int getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(int accessTime) {
        this.accessTime = accessTime;
    }

    private int accessTime;

    public ProcessVariable[] getPage() {
        return page;
    }

    public void setPage(ProcessVariable[] page) {
        this.page = page;
    }



    public Page() {
        this.page =new ProcessVariable[400];
        for(ProcessVariable p : page){
            p.setValue("EMPTY");
            p.setMemory_require(0);
        }
        this.accessTime=0;
        this.freeStorage=400;
    }
}
