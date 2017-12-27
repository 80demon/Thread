package com.panjoy.proxy.demo1;

public class Client {
    public static void main(String[] args) {
      /*   1
      Target target=new TargetImpl();
       target= (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new TargetProxy(target));
        target.execute();
        */

        //2
        Target target=(Target) TargetProxy.bind(new TargetImpl());
        target.execute();
    }
}
