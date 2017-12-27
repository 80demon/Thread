package com.panjoy.proxy.demo3;

import com.panjoy.proxy.demo1.Target;
import com.panjoy.proxy.demo1.TargetImpl;
import com.panjoy.proxy.demo2.LogInterceptor;

public class Client {
    public static void main(String[] args) {

        Interceptor interceptor=new LogInteceptor();
        Target target = (Target) interceptor.register(new TargetImpl());
        target.execute();


    }
}
