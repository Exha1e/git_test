package com.atguigu.juc.demo3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo4 {
    private static Integer num = 10;

    public static void main(String[] args) throws Exception{
        System.out.println("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("加10任务开始");
                num += 10;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return num;
        }).thenApply(integer -> {
            return num * num;
        });
        Integer integer = future.get();
        System.out.println("主线程结束, 子线程的结果为:" + integer);
    }
}
