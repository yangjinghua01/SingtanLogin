package com.example.myapplication.Single2.sync;


public class Singleton1 {
    private static Singleton1 mInstance;

    private Singleton1() {

    }

    //虽说解决了线程安全的问题，但是又会出现效率的问题。
    public static synchronized Singleton1 getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton1();
        }
        return mInstance;
    }
}
