package com.atguigu.juc.demo;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class test {
    public static void main(String[] args) {
        demo2 demo2 = new demo2();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo2.add();
            }
        },"线程1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo2.deCount();
            }
        },"线程2").start();

       /* demo3 demo3 = new demo3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demo3.printA();
            }
        },"线程A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demo3.printB();
            }
        },"线程B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demo3.printC(i);
            }
        },"线程C").start();*/
    }
}
