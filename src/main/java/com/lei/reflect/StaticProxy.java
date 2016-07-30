package com.lei.reflect;

/**
 * Created by com.lei on 16-1-23.
 */
public class StaticProxy implements MyInterface {
    MyInterface proxied;

    public StaticProxy(MyInterface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        System.out.println("Proxied by " + this.getClass().getCanonicalName());
        proxied.doSomething();
    }

    public void doSomethingElse() {
        System.out.println("Proxied by " + this.getClass().getCanonicalName());
        proxied.doSomethingElse();
    }
}
