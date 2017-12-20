package com.panjoy.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 1 CAS操作需要硬件的配合；
 * 2保证各个CPU的缓存（L1、L2、L3、跨CPU Socket、主存）的数据一致性，通讯开销很大，在多处理器系统上更严重；
 * 3没法保证公平性，不保证等待进程/线程按照FIFO顺序获得锁。
 * https://coderbee.net/index.php/concurrent/20131115/577/comment-page-1
 */
public class SpinLock {
    private AtomicReference<Thread> owner=new AtomicReference<Thread>();
    public void lock(){
        Thread currentThread=Thread.currentThread();
        // 如果锁未被占用，则设置当前线程为锁的拥有者,自旋
        while(!owner.compareAndSet(null,currentThread)){

        }
    }
    public void unlock(){
        Thread currentThread=Thread.currentThread();
        owner.compareAndSet(currentThread,null);
    }
}
