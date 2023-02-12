package com.example.myapplication.Singple3;

import com.example.myapplication.Single2.sync.Singleton;

public class Singleton3 {
    private static volatile  Singleton3 mInstance;
    public static Singleton3 getInstance(){
        return SingletonHolder.mInstance;
    }
    public static  class  SingletonHolder{
        private static volatile Singleton3 mInstance = new Singleton3();
    }
}
