package com.panjoy.classloader;

import java.util.Random;

class Test1 {
    public static int a= 6;
    static {
        System.out.println("test1----------------");
    }

    public Test1() {
        System.out.println("---------------------");
    }
}

public class Demo1 {
    public static void main(String[] args) {
    System.out.println(Test1.a);
    }
}
