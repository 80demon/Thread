package com.panjoy.concurrent;

import java.util.concurrent.BlockingQueue;

public class Producer implements  Runnable {
    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
     for(int i=0 ;i<100;i++){
         Message msg=new Message(i+"------");
         try {
             queue.put(msg);
             Thread.sleep(i);
             System.out.println("Producer produced"+msg.getMsg());
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
        Message exit=new Message("exit");
        try{
            queue.put(exit);
        }catch (InterruptedException e){

        }
    }
}
