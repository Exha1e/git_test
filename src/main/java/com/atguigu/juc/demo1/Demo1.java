package com.atguigu.juc.demo1;

import java.util.concurrent.FutureTask;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        System.out.println("准备");
        FutureTask<String> futureTask = new FutureTask(()->{
            Thread.sleep(3000);
            return "hello world";
        });
        new Thread(futureTask).start();
        System.out.println("开始");
        System.out.println(futureTask.get());
        System.out.println("结束");
    }
}
