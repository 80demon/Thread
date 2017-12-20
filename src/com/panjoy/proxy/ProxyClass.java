package com.panjoy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyClass implements InvocationHandler {
    private Object object;

    public ProxyClass(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--before method " + method.getName());
        Object result = method.invoke(object, args);
        return result;
    }
}
