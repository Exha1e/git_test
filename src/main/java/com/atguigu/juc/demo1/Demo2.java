package com.atguigu.juc.demo1;

import java.util.concurrent.CountDownLatch;

public class Demo2 {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                try {
                    if (Thread.currentThread().getName().equals("同学6")){
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"离开了");
            },"同学"+i).start();
        }
        countDownLatch.await();
        System.out.println("人都走完了,班主任关门");
    }
}
