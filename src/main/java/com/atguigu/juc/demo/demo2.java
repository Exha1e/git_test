package com.atguigu.juc.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo2 {
    //定义一个常量
    int num = 1;
    //定义锁
    Lock lock = new ReentrantLock();
    //定义钥匙
    Condition condition = lock.newCondition();

    //加
    public void add(){
        try {
            lock.lock();
            if (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"加操作成功,当前数值"+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //减
    public void deCount(){
        try {
            lock.lock();
            if (num!=1){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"减操作成功,当前数值"+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
