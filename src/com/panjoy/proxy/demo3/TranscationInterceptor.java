package com.panjoy.proxy.demo3;

public class TranscationInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Exception {
        System.out.println("transcation run");
        return invocation.process();
    }

    @Override
    public Object register(Object object) {
        return TargetProxy.bind(object,this);
    }
}
