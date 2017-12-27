package com.panjoy.proxy.demo2;

import com.panjoy.proxy.demo1.Target;
import com.panjoy.proxy.demo1.TargetImpl;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        Stack<Interceptor> interceptorStack = new Stack<>();
        interceptorStack.add(new LogInterceptor());
        interceptorStack.add(new TranscationInterceptor());
        Target target = (Target) TargetProxy.getInstance(new TargetImpl(), interceptorStack);
        target.execute();
    }
}

