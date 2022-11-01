package Sprint3.Uppgift14;

import java.util.ArrayList;

public class MyQueue {

    ArrayList<QueueElement> objectArrayList = new ArrayList<>();

    public synchronized void put(QueueElement obj){
        int priority = Thread.currentThread().getPriority();
        int k = 0;
        if(objectArrayList.size() == 0){
            objectArrayList.add(obj);
        }
        for (int i = 0; i < objectArrayList.size(); i++) {
            if(priority<objectArrayList.get(i).getPri()){
                k++;
            }
        }
        objectArrayList.add(k,obj);
        notify();
    }

    public synchronized QueueElement take() {
        while (objectArrayList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        QueueElement e = objectArrayList.get(0);
        objectArrayList.remove(0);
        return e;
    }

    public int size() {
        return objectArrayList.size();
    }
    public void printQueue(){
        objectArrayList.forEach(o -> System.out.println(o.getText()));
    }

}
