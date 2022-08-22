package com.atguigu.juc.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo3 {
    //定义通讯对象
    //0代表线程A,1代表线程B,2代表线程C
    private int number = 0;
    //定义锁
    private Lock lock = new ReentrantLock();
    //定义钥匙A
    private Condition conditionA = lock.newCondition();
    //定义钥匙B
    private Condition conditionB = lock.newCondition();
    //定义钥匙C
    private Condition conditionC = lock.newCondition();

    //打印A的方法
    public void printA(){
        try {
            lock.lock();
            if (number!=0){
                conditionA.await();
            }
            //打印5次A
            for (int i = 0; i < 5; i++) {
                System.out.println("AAAAAAA");
            }
            number=1;
            //B线程开启
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    //打印A的方法
    public void printB(){
        lock.lock();
        try {
            if (number!=1){
                conditionB.await();
            }
            //打印5次B
            for (int i = 0; i < 10; i++) {
                System.out.println("BBBBBBB");
            }
            number=2;
            //C线程开启
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    //打印C的方法
    public void printC(int j){
        lock.lock();
        try {
            if (number!=2){
                conditionC.await();
            }
            //打印5次A
            for (int i = 0; i < 15; i++) {
                System.out.println("CCCCCCC");
            }
            System.out.println(Thread.currentThread().getName()+"打印了第"+j+"次");
            number=0;
            //A线程开启
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
