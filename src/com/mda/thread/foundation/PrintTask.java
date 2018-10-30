package com.mda.thread.foundation;

public class PrintTask implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("Thread com.mda.thread.communication.washroom.Communication is running");
    }
}