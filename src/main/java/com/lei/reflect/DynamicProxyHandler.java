package com.lei.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by com.lei on 16-1-23.
 */
public class DynamicProxyHandler implements InvocationHandler {
    Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Pass dymatic call through proxy " + proxied.getClass().getCanonicalName());
        Object result = method.invoke(proxied, args);
        System.out.println("End dymatic proxy call");
        return result;
    }
}
