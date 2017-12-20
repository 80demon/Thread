package com.panjoy.thread;

public class WaitTest {
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        synchronized (t1) {
            System.out.println(Thread.currentThread().getName() + "---------start");
            t1.start();
            try {

                Thread.sleep(3000);
                t1.wait();
                t1.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + "-------------------end");

    }
}
