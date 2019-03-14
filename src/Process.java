import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Process {
    private int pID; //secure process ID, must be unique
    private String name;
    private String state; //Starts at ready, Ends at terminated
    private int timeSlice; //how long program should run at once
    Process next; //These are default access intentionally
    Process prev;
    LinkedList files;

    public Process(int pID, String name){
        this.pID = pID;
        this.name = name;
        next = null;
        prev = null;
        state = "ready";
        timeSlice = 1;
        files = new LinkedList();
    }

    public void openFile(String newFile){
        files.add(newFile);
    }

    public void closeFile (String fileName){
        Iterator fileIter = files.listIterator(0);
        while(fileIter.hasNext()){
            if(fileIter.next() == fileName){
                fileIter.remove();
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public String toString(){
        return "Process " + pID + "\t" + name + " " + state + " ";
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTimeSlice() {
        return timeSlice;
    }

    public void setTimeSlice(int timeSlice) {
        this.timeSlice = timeSlice;
    }

    /*
    public Process getNext() {
        return next;
    }

    public void setNext(Process next) {
        this.next = next;
    }

    public Process getPrev() {
        return prev;
    }

    public void setPrev(Process prev) {
        this.prev = prev;
    }
    */
}
