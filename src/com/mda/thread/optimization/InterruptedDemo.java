package com.mda.thread.optimization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptedDemo
{
    public static void main(String[] args) throws Exception
    {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                lock.lock();

                try
                {
                    System.out.println("Thread t1 get lock");

                    try
                    {
                        Thread.sleep(5000L);
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                finally
                {
                    lock.unlock();

                }
            }
        }, "t1");

        t1.start();

        Thread.sleep(1000L);

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    lock.lockInterruptibly();
                }
                catch (InterruptedException e)
                {
                    System.out.println("Other thread send interrupt signal,lockInterruptibly return:" + e);
                    System.out.println("Thread t2 status: " + Thread.currentThread().isInterrupted());
                }
            }
        }, "t2");

        t2.start();

        Thread.sleep(1000L);

        t2.interrupt();
        System.out.println("In main Thread, Thread t2 status: " + Thread.currentThread().isInterrupted());

    }
}
