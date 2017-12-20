package com.panjoy.thread;

public class Thread1 extends Thread {
    @Override
    public void run() {
        try {
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + "-------------start");
                Thread.sleep(3000);
                //notify();
                wait();
                System.out.println(Thread.currentThread().getName() + "-------------end");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
