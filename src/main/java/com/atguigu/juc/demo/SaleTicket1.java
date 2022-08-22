package com.atguigu.juc.demo;

public class SaleTicket1 {
    //定义票的数量
    private int num = 30;
    //定义锁的次数
    private int count =0;
    //定义售票的方法
    public synchronized void sale(){
        if (num>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"买了1张票,还剩下"+num+"张票");
            count++;
            System.out.println(Thread.currentThread().getName()+"锁了第"+count+"次");
            sale();
        }
    }
}
