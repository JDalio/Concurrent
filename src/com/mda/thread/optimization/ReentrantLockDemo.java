package com.mda.thread.optimization;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo
{

    public static void main(String[] args)
    {
        Lock lock = new ReentrantLock();
        Random random = new Random();

        while (true)
        {
            if (lock.tryLock())
            {
                try
                {

                }
                finally
                {
                    lock.unlock();
                }
            } else
            {
                try
                {
                    Thread.sleep(random.nextInt(1000));
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
