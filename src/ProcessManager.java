import java.util.NoSuchElementException;

public class ProcessManager {
    private static ReadyQueue r = new ReadyQueue();

    /**
     * o	create a process whose name is systemd
     * o	create 10 more processes with the names: agetty, chronyd, crond, dbus-daemon, firewalld, irqbalance, lvmetad, polkitd, sshd, rsyslogd
     * o	run 1 round of round robin scheduling
     * o	sshd process opens two files: hello.c and hello.h.
     * o	sshd process closes hello.c file.
     * o	terminate the process whose name is crond
     * o	print the ready queue
     * o	terminates all the processes
     * o	print the ready queue
     * o	exit the program
     * @param args
     */
    public static void main(String[] args){

        createProcess("systemd");
        createProcess("agetty");
        createProcess("chronyd");
        createProcess("crond");
        createProcess("dbusDaemon");
        createProcess("firewalld");
        createProcess("irqbalance");
        createProcess("lvmetad");
        createProcess("polkitd");
        createProcess("sshd");
        createProcess("rsyslogd");

        //System.out.println(r.toString());//debug

        roundRobin();

        Process sshd = getProcess("sshd");
        sshd.openFile("hello.c");
        sshd.openFile("hello.h");

        sshd.closeFile("hello.c");

        terminateProcess(getProcess("crond").getpID());

        System.out.println(r.toString());

        while(!r.isEmpty()){
            terminateProcess(r.getHead().getpID());
        }

        System.out.println(r.toString());
    }

    static public Process getProcess(String name){
        if (r.isEmpty()) {
            throw new NullPointerException();
        }
        else{
            Process p = r.getHead();
            for(int i = 0; i < r.getNProcesses(); i++){
                if(p.getName().equals(name))
                    return p;
                p = p.next;
            }
            throw new NoSuchElementException();
        }
    }

    static public int createProcess(String name){
        if (r.isEmpty()) {
            r.addProcess(new Process(1, name));
            return 1;
        }
        else{
            int max = 1;
            Process p = r.getHead();
            for(int i = 0; i < r.getNProcesses(); i++){
                if(p.getpID() > max)
                    max = p.getpID();
                p = p.next;
            }
            r.addProcess(new Process(max + 1, name));
            return max+1;
        }
    }


    static public String terminateProcess(int pID){//what this method should return was not specified in the insructions so i will assume it should return the state
        if (r.isEmpty()) {
            throw new NullPointerException("The readyQueue is empty");
        }
        else{

            String state = null;
            for(int i = 0; i < r.getNProcesses(); i++){
                if(r.getHead().getpID() == pID)
                    state = r.removeProcess();
                r.contextSwitch();
            }
            if(state == null){
                throw new NoSuchElementException();
            }
            else{
                return state;
            }
        }
    }
    static public void roundRobin(){
        if(r.isEmpty())
            return;
        else{
            for(int i = 0; i < r.getNProcesses(); i++){
                r.contextSwitch();
            }
        }
    }
}
