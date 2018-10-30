package com.mda.thread.pooling;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory
{
    private static int COUTER = 0;

    private static String THREAD_PREFIX = "myThread_";

    @Override
    public Thread newThread(Runnable runnable)
    {
        int i = COUTER++;
        return new Thread(runnable, THREAD_PREFIX + i);
    }
}
