package com.mda.thread.foundation;

public class PrintThread extends Thread
{

    @Override
    public void run()
    {
        System.out.println("com.mda.thread.foundation.PrintThread Inner run method is running");
    }
}
