package com.panjoy.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决了公平性，安装排队顺序
 */
public class TicketLock {
    private AtomicInteger serviceNo=new AtomicInteger();
    private AtomicInteger ticketNo=new AtomicInteger();
    public  int lock(){
        //先生成一个排队号
        int myTicketNo=ticketNo.getAndIncrement();
        // 只要当前服务号不是自己的就不断轮询
        while(serviceNo.get()!=myTicketNo){
        }
        return myTicketNo;
    }
    public void unlock(int myTicketNo){
        int next=myTicketNo+1;
        serviceNo.compareAndSet(myTicketNo,next);
    }
}
