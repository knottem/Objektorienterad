package Sprint3.Uppgift14;

public class Producer extends Thread{

    private int time;
    private MyQueue myQueue;
    private QueueElement obj;



    public Producer(String text,int time, MyQueue myQueue, int priority) {
        this.time = time * 1000;
        this.myQueue = myQueue;
        obj = new QueueElement(text, priority);

    }

    public void run(){
        setPriority(obj.getPri());
        while(!Thread.interrupted()){
            try{
                Thread.sleep(time);
                myQueue.put(obj);
                System.out.println(obj.getText() + " las in.");
            }
            catch (InterruptedException e){
                break;
            }
        }
    }

}
