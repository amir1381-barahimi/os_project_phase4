import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        ProcessVariable[] vars1={new ProcessVariable("var1",4),new ProcessVariable("var2",8),new ProcessVariable("var3",240),new ProcessVariable("var4",148),new ProcessVariable("var5",300)};
        Process p1=new Process("P1",new ArrayList<>(Arrays.asList(vars1)));

        ProcessVariable[] vars2={new ProcessVariable("var1",12),new ProcessVariable("var2",600),new ProcessVariable("var3",480),new ProcessVariable("var4",210),new ProcessVariable("var5",150)};
        Process p2=new Process("P2",new ArrayList<>(Arrays.asList(vars2)));

        ProcessVariable[] vars3={new ProcessVariable("var1",50),new ProcessVariable("var2",800),new ProcessVariable("var3",250),new ProcessVariable("var4",100),new ProcessVariable("var5",430)};
        Process p3=new Process("P3",new ArrayList<>(Arrays.asList(vars3)));

        Process[] processes={p1,p2,p3};

        for (Process p:processes){
            for (ProcessVariable pv: p.getVars_process()){
                if(pv.getMemory_require()<=MainMemory.freeStorage){
                    setInMainMemory(pv.getMemory_require());
                }else{
                    setInVirtualMemory(pv.getMemory_require());
                }
            }
        }


    }
    public static void setInMainMemory(int reqMemory){

    }
    public static void setInVirtualMemory(int reqMemory){

    }

}
