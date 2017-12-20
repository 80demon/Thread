package com.panjoy.ExecutorPool;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public  static  void main(String[] args){
        ExecutorService executor= Executors.newFixedThreadPool(5);
        for(int i=0;i<20;i++){
            WorkerThread worker=new WorkerThread("thread"+i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
