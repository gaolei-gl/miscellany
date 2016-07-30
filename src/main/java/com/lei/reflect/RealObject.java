package com.lei.reflect;

/**
 * Created by com.lei on 16-1-23.
 */
public class RealObject implements MyInterface, MyAnotherInterface {
    public void doSomething() {
        System.out.println("do some thing in " + this.getClass().getCanonicalName());
    }

    public void doSomethingElse() {
        System.out.println("do some thing else in " + this.getClass().getCanonicalName());
    }

    public int add(int a, int b) {
        return a + b;
    }

    public String display(String s) {
        return s;
    }
}
