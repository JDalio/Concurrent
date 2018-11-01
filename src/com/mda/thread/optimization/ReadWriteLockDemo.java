package com.mda.thread.optimization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo
{
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    private int i;

    public int getI()
    {
        readLock.lock();

        try
        {
            return i;
        }
        finally
        {
            readLock.unlock();
        }
    }

    public void setI(int i)
    {
        writeLock.lock();

        try
        {
            this.i = i;
        }
        finally
        {
            writeLock.unlock();
            ;
        }
    }
}
