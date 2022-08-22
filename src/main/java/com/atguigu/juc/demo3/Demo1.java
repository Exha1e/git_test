package com.atguigu.juc.demo3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"子线程开始干活");
                //子线程睡5秒
                Thread.sleep(5000);
                //在子线程中完成主线
                future.complete("success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        //主方法调用方法阻塞
        System.out.println("主线程调用get方法获取结果为: " +future.get());
        System.out.println("主线程完成,阻塞结束");
    }
}
