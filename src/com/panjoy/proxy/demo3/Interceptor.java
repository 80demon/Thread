package com.panjoy.proxy.demo3;

public interface Interceptor {
    Object intercept(Invocation invocation) throws Exception;

    Object register(Object object);
}
