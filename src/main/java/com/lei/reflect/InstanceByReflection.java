package com.lei.reflect;

import org.reflections.Reflections;

public class InstanceByReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.lei.reflect.RealObject");
        Reflections reflections = new Reflections("com.lei");
        for (Class s  : reflections.getSubTypesOf(com.lei.reflect.MyInterface.class)) {
            System.out.println(s);
        }
//        MyInterface iface = (MyInterface) clazz.newInstance();
//        iface.doSomething();
    }
}
