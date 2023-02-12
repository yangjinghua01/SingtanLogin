package com.example.myapplication.Single2.sync;

public class VolatileTest {
    int a = 1;
    int b = 2;

    private void print() {
        System.out.println("b=" + b + "a=" + a);
    }

    private void change() {
        b = 3;
        a = b;
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    volatileTest.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    volatileTest.print();
                }
            }).start();
        }
    }
}
