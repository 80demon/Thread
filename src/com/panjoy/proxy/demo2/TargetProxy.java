package com.panjoy.proxy.demo2;

import com.panjoy.proxy.demo1.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Stack;

public class TargetProxy implements InvocationHandler {
    private Object target;
    private Stack<Interceptor> interceptorStack;

    public TargetProxy(Object target, Stack<Interceptor> interceptorStack) {
        this.target = target;
        this.interceptorStack = interceptorStack;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Interceptor interceptor:interceptorStack){
            interceptor.intercept();
        }
        return method.invoke(target,args);
    }
    public  static  Object getInstance(Object o,Stack<Interceptor> stack){
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),new TargetProxy(o,stack));
    }
}
