package com.panjoy.proxy.demo3;

import com.panjoy.proxy.demo1.Target;
import com.panjoy.proxy.demo1.TargetImpl;

public class Client {
    public static void main(String[] args) {
        //https://www.cnblogs.com/kakaxisir/p/4579110.html
        Interceptor interceptor=new LogInteceptor();
        Target target = (Target) interceptor.register(new TargetImpl());
        target.execute();


    }
}
