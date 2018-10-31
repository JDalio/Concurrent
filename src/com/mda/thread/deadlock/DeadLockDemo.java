package com.mda.thread.deadlock;

import com.mda.thread.communication.restaurant.SleepUtil;

public class DeadLockDemo
{
    public static void main(String[] args)
    {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    synchronized (lock1)
                    {
                        System.out.println("Thread t1 get Lock1");
                        SleepUtil.randomSleep();
                        synchronized (lock2)
                        {
                            System.out.println("Thread t1 get lock2");
                        }
                    }
                }
            }
        }, "t1").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    synchronized (lock2)
                    {
                        System.out.println("Thread t2 get lock2");
                        SleepUtil.randomSleep();

                        synchronized (lock1)
                        {
                            System.out.println("Thread t2 get lock1");
                        }
                    }


                }
            }
        }, "t2").start();
    }
}
