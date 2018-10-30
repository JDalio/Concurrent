package com.mda.thread.pooling;

public class LongTimeTask implements Runnable
{

    private int num;

    public LongTimeTask(int num)
    {
        this.num = num;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(Thread.currentThread().getName() + " is executing " + num + " task");
            Thread.sleep(5000L);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Finish thread " + num);
    }
}
