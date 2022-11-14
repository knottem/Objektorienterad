package Sprint3.Uppgift14;

public class Consumer extends Thread{

    private int time;
    private MyQueue myQueue;

    public Consumer(int time, MyQueue myQueue) {
        this.time = time * 1000;
        this.myQueue = myQueue;
    }

    public void run(){
        while(!Thread.interrupted()){
            try{
                Thread.sleep(time);
                QueueElement e = myQueue.take();
                System.out.println(e.getText() + " tas ut.");
            }
            catch (InterruptedException e){
                break;
            }
        }
    }
}
