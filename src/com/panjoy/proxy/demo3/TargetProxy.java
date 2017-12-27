package com.panjoy.proxy.demo3;

import com.panjoy.proxy.ProxyClass;
import com.panjoy.proxy.demo1.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {
    private Object target;
    private Interceptor interceptor;

    public TargetProxy(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(target, method, args);
        return interceptor.intercept(invocation);
    }

    public static Object bind(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TargetProxy(target, interceptor));
    }
}
