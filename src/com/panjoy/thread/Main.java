package com.panjoy.thread;

import java.util.concurrent.ExecutorService;

public class Main
{
    public  static  void main(String [] args){
        Main main = new Main();
        Thread t = new Thread(main.runnable);
        System.out.println("mainmainmain");
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            try {
                while (i < 1000) {
                    Thread.sleep(500);
                    System.out.println("--------"+Thread.currentThread().isInterrupted());
                    System.out.println(i++);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    }

