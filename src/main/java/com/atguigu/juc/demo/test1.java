package com.atguigu.juc.demo;

public class test1 {
    public static void main(String[] args) {
/*        SaleTicket saleTicket = new SaleTicket();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                saleTicket.sale();
            }
        },"同学A").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                saleTicket.sale();
            }
        },"同学B").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                saleTicket.sale();
            }
        },"同学C").start();*/

        SaleTicket1 saleTicket1 = new SaleTicket1();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                saleTicket1.sale();
            }
        },"同学A").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                saleTicket1.sale();
            }
        },"同学B").start();
    }
}
