package com.panjoy.classloader;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;

class Singleton {
    private static Singleton instance = new Singleton();
    public static int i = 0;
    public static int j;

    private Singleton() {
        i++;
        j++;
    }

    public static Singleton getInstance() {
        return instance;
    }

}

class Thread1 implements Runnable {
    Constructor<Unsafe> con;
    Unsafe UNSAFE = null;
    @Override
    public void run() {
        try{
            park();
        }
        catch (Exception e){
        }
    }
    public void park() throws  Exception{
        con = (Constructor<Unsafe>) Class.forName("sun.misc.Unsafe").getDeclaredConstructor();
        con.setAccessible(true);
        UNSAFE= con.newInstance(null);
        try {
            Thread currThread = Thread.currentThread();
            UNSAFE.park(true, 10000000000L);
            System.out.println("thread1--------------");
        } catch (Exception e) {
           e.printStackTrace();
        }finally {
           // UNSAFE.unpark(Thread.currentThread());
        }
    }
}

public class ClassLoader1 {
    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.getInstance();
        System.out.println("i=:" + singleton.i);
        System.out.println("j=:" + singleton.j);
        Thread t1 = new Thread(new Thread1());
        t1.start();
        t1.join();
        System.out.println("SUCCESS!!!");
    }


}
