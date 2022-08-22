package com.atguigu.juc.demo1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo4 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                try {
                    if (semaphore.tryAcquire(10, TimeUnit.SECONDS)){
                        System.out.println(Thread.currentThread().getName()+"停车成功");
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+"离开");
                    }else {
                        System.out.println(Thread.currentThread().getName()+"放弃停车");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"车车"+i).start();
        }
    }
}
