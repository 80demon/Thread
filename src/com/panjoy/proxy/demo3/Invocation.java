package com.panjoy.proxy.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//https://www.cnblogs.com/kakaxisir/p/4579110.html
public class Invocation {
    private Object target;
    private Method method;
    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object process() throws Exception {
        return method.invoke(target, args);
    }
}
