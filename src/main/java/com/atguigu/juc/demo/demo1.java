package com.atguigu.juc.demo;

public class demo1 {

    //定义一个常量
     int num = 0;

    /**
     * 加操作
     */
    public synchronized void add(){
        try {
            //判断是否要加
            if (num != 0){
                wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"加操作成功,当前数值为"+num);
            //唤醒其他线程
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 减操作
     */
    public synchronized void deCount(){
        try {
            //判断是否要见
            if (num==0){
                wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"减操作成功,当前数值为"+num);
            //唤醒其他线程
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
