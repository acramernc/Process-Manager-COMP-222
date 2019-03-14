public class ReadyQueue {
    private Process head;//Process at beginning of the queue
    private Process tail;//Process at the end of the queue
    private int size;//Number of process in the queue

    public ReadyQueue(){
        size = 0;
    }

    public ReadyQueue(Process head){
        this.head = head;
        tail = head;
        size = 1;
    }

    public int getNProcesses(){
        return size;
    }

    public void addProcess(Process c){
        if(size == 0) {
            head = c;
            tail = c;
            size = 1;
        }
        else{
            tail.next = c;
            c.prev = tail;
            tail = c;
            size++;
        }

    }

    public String removeProcess(){
        if(size == 0){
            throw new NullPointerException("size = 0");
        }
        if(size == 1){
            head.setState("terminated");
            head = null;
            size = 0;
            return "terminated";
        }
        head.setState("terminated");
        String state = head.getState();
        head = head.next;
        head.prev = null;
        size--;

        return state;
    }

    public void contextSwitch(){
        if(size > 2) {
            Process last = tail;
            tail = head;

            tail.prev = last;
            last.next = tail;
            head = head.next;
            tail.next = null;
            head.prev = null;
        }
    }

    public String toString(){
        if(size == 1){
            return head.toString();
        }
        else if(size == 0){
            return "ReadyQueue is Empty";
        }
        else{
            String out = "";
            Process p = head;
            while(p.next != null){
                out += p.toString();
                p = p.next;
            }
            return out;
        }
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public Process getHead() {
        return head;
    }

    public Process getTail() {
        return tail;
    }
}
