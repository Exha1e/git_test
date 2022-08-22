package com.atguigu.juc.demo1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo3 {
    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐了7颗龙珠了,召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                try {
                    if (Thread.currentThread().getName().equals("龙珠4")){
                        System.out.println("龙珠4开始抢");
                        Thread.sleep(5000);
                    }
                    System.out.println(Thread.currentThread().getName()+"抢到了");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"龙珠"+i).start();
        }
    }
}
