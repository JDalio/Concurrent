package com.mda.thread.foundation;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread thread, Throwable throwable)
    {
        System.out.println("Abnormal Thread name "+thread.getName());
        System.out.println("Exception  "+throwable);
    }
}
