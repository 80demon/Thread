package com.panjoy.proxy.demo2;

public class LogInterceptor implements Interceptor {
    @Override
    public void intercept() {
        System.out.println("logger run");
    }
}
