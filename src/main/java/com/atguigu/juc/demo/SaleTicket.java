package com.atguigu.juc.demo;

public class SaleTicket {
    //定义票的数量
    private int num = 30;
    //定义售票的方法
    public synchronized void sale(){
        if (num>0){
            num--;
            System.out.println(Thread.currentThread().getName()+"买了1张票,还剩下"+num+"张票");
        }
    }
}
