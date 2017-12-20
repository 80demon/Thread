package com.panjoy.concurrent;

import java.util.concurrent.BlockingQueue;

public class Consumer implements   Runnable{
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message msg;
        try {
            //consuming messages until exit message is received
            while ((msg = queue.take()).getMsg() != "exit") {
                Thread.sleep(10);
                System.out.println("Consumer consumerd" + msg.getMsg());
            }
        }catch ( InterruptedException e){
            e.printStackTrace();
        }

    }
}
