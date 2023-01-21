

public class Page {
    private ProcessVariable[] page;


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
    }
}
