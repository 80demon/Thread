package com.panjoy.thread;

class Depot {
    //容量
    private int capacity;
    //库存量
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public Depot(int capacity, int size) {
        this.capacity = capacity;
        this.size = size;
    }

    public synchronized void produce(int val) {
        try {
            int left = val;
            while (left > 0) {
                if (size >= capacity)
                    wait();
                int incr = (size + left) > capacity ? capacity - size : left;
                size = size + incr;
                left = left - incr;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n", Thread.currentThread().getName(), val, left, incr, size);
                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void consume(int val) {
        int left = val;
        try {
            while (left > 0) {
                if (size <= 0)
                    wait();
                int dec = size < left ? size : left;
                size = size - dec;
                left = left - dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);
                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(final int val) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.produce(val);
            }
        }).start();
    }
}

class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consume(final int val) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.consume(val);
            }
        }).start();
    }
}

public class Client2 {
    public static void main(String args[]) {

        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Consumer consumer = new Consumer(depot);
        producer.produce(100);
        consumer.consume(50);
        producer.produce(500);
        consumer.consume(50);
        consumer.consume(400);

        System.out.print("teeee"+Thread.currentThread().isDaemon());
    }
}
