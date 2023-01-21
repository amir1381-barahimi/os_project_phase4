import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static MainMemory mainMemory = new MainMemory();
    public static VirtualMemory virtualMemory = new VirtualMemory();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProcessVariable[] vars1 = {new ProcessVariable("var1", 4, "P1"), new ProcessVariable("var2", 8, "P1"), new ProcessVariable("var3", 240, "P1"), new ProcessVariable("var4", 148, "P1"), new ProcessVariable("var5", 300, "P1")};
        Process p1 = new Process("P1", new ArrayList<>(Arrays.asList(vars1)));

        ProcessVariable[] vars2 = {new ProcessVariable("var1", 12, "P2"), new ProcessVariable("var2", 50, "P2"), new ProcessVariable("var3", 38, "P2"), new ProcessVariable("var4", 100, "P2"), new ProcessVariable("var5", 200, "P2")};
        Process p2 = new Process("P2", new ArrayList<>(Arrays.asList(vars2)));

        ProcessVariable[] vars3 = {new ProcessVariable("var1", 50, "P3"), new ProcessVariable("var2", 50, "P3"), new ProcessVariable("var3", 200, "P3"), new ProcessVariable("var4", 200, "P3"), new ProcessVariable("var5", 400, "P3")};
        Process p3 = new Process("P3", new ArrayList<>(Arrays.asList(vars3)));

        ProcessVariable[] vars4 = {new ProcessVariable("var1", 200, "P4"), new ProcessVariable("var2", 400, "P4"), new ProcessVariable("var3", 400, "P4"), new ProcessVariable("var4", 200, "P4"), new ProcessVariable("var5", 200, "P4")};
        Process p4 = new Process("P4", new ArrayList<>(Arrays.asList(vars4)));

        ProcessVariable[] vars5 = {new ProcessVariable("var1", 100, "P5"), new ProcessVariable("var2", 100, "P5"), new ProcessVariable("var3", 100, "P5"), new ProcessVariable("var4", 100, "P5"), new ProcessVariable("var5", 400, "P5")};
        Process p5 = new Process("P5", new ArrayList<>(Arrays.asList(vars5)));

        ProcessVariable[] vars6 = {new ProcessVariable("var1", 400, "P6"), new ProcessVariable("var2", 400, "P6"), new ProcessVariable("var3", 200, "P6"), new ProcessVariable("var4", 200, "P6"), new ProcessVariable("var5", 400, "P6")};
        Process p6 = new Process("P6", new ArrayList<>(Arrays.asList(vars6)));

        Process[] processes = {p1, p2, p3, p4, p5, p6};

        for (Process p : processes) {
            for (ProcessVariable pv : p.getVars_process()) {
                boolean flag = setInMainMemory(pv);
                if (!flag) setInVirtualMemory(pv);
            }
        }

        System.out.println("Setting Processes in Memory Finished.");

        System.out.println("Enter process and variable name :");
        String processName = sc.next();
        String processVal = sc.next();
        findProcess(processName, processVal);

        while (sc.hasNextLine()) {
            System.out.println("Enter process and variable name :");
            processName = sc.next();
            processVal = sc.next();
            findProcess(processName, processVal);
        }
    }

    public static boolean setInMainMemory(ProcessVariable processVariable) {
        boolean flag = false;
        for (int i = 0; i < mainMemory.getMainMemory().length; i++) {
            System.out.println(1);
            if (mainMemory.getMainMemory()[i].getFreeStorage() >= processVariable.getMemory_require()) {
                System.out.println("i" + i);
                int j = 400 - mainMemory.getMainMemory()[i].getFreeStorage();
                int last = j + processVariable.getMemory_require();
                while (j != last) {
                    System.out.println(2);
                    mainMemory.getMainMemory()[i].getPage()[j] = processVariable;
                    j++;
                }
                mainMemory.getMainMemory()[i].setFreeStorage(mainMemory.getMainMemory()[i].getFreeStorage() - processVariable.getMemory_require());
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void setInVirtualMemory(ProcessVariable processVariable) {
        for (int i = 0; i < virtualMemory.getVirtualMemory().length; i++) {
            System.out.println(3);
            if (virtualMemory.getVirtualMemory()[i].getFreeStorage() >= processVariable.getMemory_require()) {
                int j = 400 - virtualMemory.getVirtualMemory()[i].getFreeStorage();
                int last = j + processVariable.getMemory_require();
                while (j != last) {
                    System.out.println(4);
                    virtualMemory.getVirtualMemory()[i].getPage()[j] = processVariable;
                    j++;
                }
                virtualMemory.getVirtualMemory()[i].setFreeStorage(virtualMemory.getVirtualMemory()[i].getFreeStorage() - processVariable.getMemory_require());
                break;
            }
        }
    }

    public static void findProcess(String processName, String processVal) {
        boolean flag = false;
        for (int i = 0; i < mainMemory.getMainMemory().length; i++) {
            for (int j = 0; j < mainMemory.getMainMemory()[i].getPage().length; j++) {
                if (mainMemory.getMainMemory()[i].getPage()[j].getProcess_name().equals(processName) && mainMemory.getMainMemory()[i].getPage()[j].getValue().equals(processVal)) {
                    System.out.println("Relative Address :" + (j));
                    System.out.println("Logical Address :" + "Page:" + (i + 1) + "\t Offset:" + j);
                    System.out.println("Physical Address :" + (i * 400 + j));
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        if (!flag) {
            int index = mainMemory.findMinimumAccess();

            for (int i = 0; i < virtualMemory.getVirtualMemory().length; i++) {
                for (int j = 0; j < virtualMemory.getVirtualMemory()[i].getPage().length; j++) {
                    if (virtualMemory.getVirtualMemory()[i].getPage()[j].getProcess_name().equals(processName) && virtualMemory.getVirtualMemory()[i].getPage()[j].getValue().equals(processVal)) {
                        Page temp;
                        temp = mainMemory.getMainMemory()[index];
                        mainMemory.getMainMemory()[index] = virtualMemory.getVirtualMemory()[i];
                        virtualMemory.getVirtualMemory()[i] = temp;

                        System.out.println("Relative Address :" + (j));
                        System.out.println("Logical Address :" + "Page:" + (index + 1) + "\t Offset:" + j);
                        System.out.println("Physical Address :" + (index * 400 + j));
                    }
                }
            }
        }
    }
}

