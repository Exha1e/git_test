package com.atguigu.juc.demo3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("主线程开始");
        //运行一个没有返回值的异步任务
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("子线程启动干活");
                Thread.sleep(5000);
                System.out.println("子线程完成");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "子线程结束";
        });
        //主线程阻塞
        String s = future.get();
        System.out.println("主线程结束"+s);
    }
}
