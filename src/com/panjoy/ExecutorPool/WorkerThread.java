package com.panjoy.ExecutorPool;

public class WorkerThread  implements Runnable{
    private  String commond;

    public WorkerThread(String commond) {
        this.commond = commond;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start.commond"+commond);
        processCommand();
        System.out.println(Thread.currentThread().getName()+".end");
    }
    private void processCommand() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
        }

    }

}
