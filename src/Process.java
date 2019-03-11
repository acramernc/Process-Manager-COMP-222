public class Process {
    private int pID; //secure process ID, must be unique
    private String name;
    private String state; //Starts at ready, Ends at terminated
    private int timeSlice; //how long program should run at once
    //TODO: initialize files and decide what data structure to use

    public Process(int pID, String name){
        this.pID = pID;
        this.name = name;
        state = "ready";
        timeSlice = 1;
        //TODO initialize files here as well
    }

    public void openFile(String newFile){
        //TODO this should add a new file to the files structure
    }

    public void closeFile (String fileName){
        //TODO this should remove fileName from files, throw error if file doesnt exist
    }

    public String toString(){
        return "Process " + pID + "\t" + name + " " + state;
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
}
