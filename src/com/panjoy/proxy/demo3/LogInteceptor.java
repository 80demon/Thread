package com.panjoy.proxy.demo3;

import com.panjoy.proxy.demo1.Target;

public class LogInteceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Exception {
        System.out.println("log run");
        return invocation.process();
    }

    @Override
    public Object register(Object object) {
        return TargetProxy.bind(object,this);
    }
}
