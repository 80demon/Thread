package com.panjoy.proxy.demo2;

public class TranscationInterceptor implements Interceptor {
    @Override
    public void intercept() {
        System.out.println("transcation  run");
    }
}
