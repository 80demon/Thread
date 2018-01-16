package com.panjoy.generic;

public class FX<T> {
    private T obj;

    public FX(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
    public void show(){
        System.out.println("obj real class is:"+obj.getClass().getName());
    }

    public static void main(String[] args) {
        FX<Integer> fx=new FX<>(100);
        fx.show();
        FX<String> stringFX=new FX<>("dkdkdkdd");
        stringFX.show();
    }
}
