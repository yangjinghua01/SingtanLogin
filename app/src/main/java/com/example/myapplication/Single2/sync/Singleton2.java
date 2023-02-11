package com.example.myapplication.Single2.sync;

public class Singleton2 {
    private static Singleton2 mInstance;

    private Singleton2() {

    }

    //虽说解决了线程安全的问题，但是又会出现效率的问题。
    public static Singleton2 getInstance() {
        if (mInstance == null) {
            synchronized (Singleton1.class) {
                if (mInstance == null) {
                    mInstance = new Singleton2();
                }
            }
        }
        return mInstance;
    }
}