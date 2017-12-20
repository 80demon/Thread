package com.panjoy.concurrent;

import java.util.concurrent.atomic.AtomicReference;
//http://www.cnblogs.com/Mainz/p/3546347.html
public class ConcurrentStack<E> {
    static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    //栈顶
    AtomicReference<Node<E>> head = new AtomicReference<>();

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        do {
            oldHead = head.get();
            oldHead.next = newHead;
        } while (head.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = head.get();
            if (oldHead == null)
                return null;
            newHead = oldHead.next;
        } while (head.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

}
