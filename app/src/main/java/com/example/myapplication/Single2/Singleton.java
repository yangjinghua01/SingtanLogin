package com.example.myapplication.Single2;

public class Singleton {
    //只有在使用的时候才会去new对象，可能更加高效
//    但是会有一些问题。
    private static Singleton mInstance;

    private Singleton() {

    }
    public static Singleton getInstance(){
        if (mInstance==null){
            mInstance = new Singleton();
        }
        return mInstance;
    }
}
