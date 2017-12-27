package com.panjoy.proxy.demo1;

public class TargetImpl implements Target {
    @Override
    public void execute() {
        System.out.println("execute");
    }
}
