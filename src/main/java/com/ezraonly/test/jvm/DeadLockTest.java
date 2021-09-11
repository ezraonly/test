package com.ezraonly.test.jvm;

/**
 * 功能描述:
 * 〈死锁测试〉
 *  jvisualvm 查看死锁
 * @Author:lwy
 * @Date: 2021/9/10 21:58
 */
public class DeadLockTest {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    System.out.println(" thread 1 lock1");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(" thread 1 lock2");

                }
            }

        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                try {
                    System.out.println(" thread 2 lock2");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(" thread 2 lock1");

                }
            }

        }).start();
        System.out.println(" main");
    }
}
