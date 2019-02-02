package zad2;

public class StringTask implements Runnable {

    private String name;
    private int number;
    private volatile TaskState state;
    private String result;
    private Thread thread;



    public StringTask (String name, int number) {
        this.name = name;
        this.number = number;
        this.state = TaskState.CREATED;
        this.result = "";
    }


    
    public TaskState getState () { return state; }
    
    public void start () {
        thread = new Thread(this, name);
        thread.start();
    }
    
    public void abort () { 
        state = TaskState.ABORTED;
        thread.interrupt();
    }

    public boolean isDone () { return state == TaskState.READY || state == TaskState.ABORTED; }

    public String getResult () {  return result; }
    
    @Override
    public void run () {
        state = TaskState.RUNNING;
        for (int i = 0; i<number && state==TaskState.RUNNING && !thread.isInterrupted(); i++) { result += name; }        
        if (state != TaskState.ABORTED) { state = TaskState.READY; }
    }

}
