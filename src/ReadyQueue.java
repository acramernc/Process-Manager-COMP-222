public class ReadyQueue {
    private Process head;//Process at beginning of the queue
    private Process tail;//Process at the end of the queue
    private int size;//Number of process in the queue

    public ReadyQueue(){
        size = 0;
        //TODO make an empty queue
    }

    public ReadyQueue(Process head){
        this.head = head;
        //TODO make a queue
    }

    public int getNProcesses(){
        return size;
    }

    public void addProcess(Process c){
        //TODO add process to end of queue
    }

    public String removeProcess(){
        //TODO remove process from head of queue, return its state
    }

    public void contextSwitch(){
        //TODO moves the process from the head of the queue to the end
    }

    public String toString(){
        //TODO return toString of each process
    }


    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }
}
