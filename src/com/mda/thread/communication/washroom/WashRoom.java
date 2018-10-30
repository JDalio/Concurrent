package com.mda.thread.communication.washroom;

public class WashRoom
{
    private volatile boolean isAvailable=false;

    private Object lock=new Object();

    public boolean isAvailable()
    {
        return isAvailable;
    }

    public void setAvailable(boolean available)
    {
        isAvailable = available;
    }

    public Object getLock()
    {
        return lock;
    }

    public void setLock(Object lock)
    {
        this.lock = lock;
    }
}
