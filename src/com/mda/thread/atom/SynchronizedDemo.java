package com.mda.thread.atom;

public class SynchronizedDemo
{
    private Object lock = new Object();

    public void m1()
    {
        synchronized (lock)
        {
            System.out.println("This is the first method");
            m2();
        }
    }

    public void m2()
    {
        synchronized (lock)
        {
            System.out.println("This is the second method");
        }
    }

    public static void main(String[] args)
    {
        SynchronizedDemo synchronizedDemo=new SynchronizedDemo();
        synchronizedDemo.m1();
    }
}
