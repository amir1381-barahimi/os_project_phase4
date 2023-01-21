public class Page {
    private ProcessVariable[] page;
    private int freeStorage;
    private int accessTime;

    public Page() {
        this.page = new ProcessVariable[400];
        for (int i = 0; i < page.length; i++) {
            page[i] = new ProcessVariable("NoName", 0, "NoName");
        }
        this.accessTime = 0;
        this.freeStorage = 400;
    }

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

    public ProcessVariable[] getPage() {
        return page;
    }

    public void setPage(ProcessVariable[] page) {
        this.page = page;
    }
}
