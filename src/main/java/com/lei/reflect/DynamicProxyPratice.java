package com.lei.reflect;

import java.lang.reflect.Proxy;

/**
 * Created by com.lei on 16-1-23.
 * 所有的被代理方法统一处理，在 DynamicProxyHandler 被统一，一次性的包装了
 */
public class DynamicProxyPratice {
    public static void main(String[] args) {
        MyInterface myInterface = new RealObject();
        myInterface.doSomething();
        myInterface.doSomethingElse();

        System.out.println();

        myInterface = new StaticProxy(new RealObject());
        myInterface.doSomething();
        myInterface.doSomethingElse();

        System.out.println();

        MyAnotherInterface myAnotherInterface = (MyAnotherInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class, MyAnotherInterface.class},
                new DynamicProxyHandler(new RealObject())
        );
        System.out.println(myAnotherInterface.add(1, 2));
    }
}
