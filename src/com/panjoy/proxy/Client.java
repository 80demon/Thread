package com.panjoy.proxy;


import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
    ITask task=(ITask) Proxy.newProxyInstance(TaskImpl.class.getClassLoader(),TaskImpl.class.getInterfaces(),new ProxyClass(new TaskImpl()));
    task.doSomething();

    }
}
