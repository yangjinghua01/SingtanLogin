package com.example.myapplication.simple1;

/**
 * 单例饿汉式子
 */
public class Singleton {
    //随着类的加载就已经new了对象
    private static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;
    }

}
