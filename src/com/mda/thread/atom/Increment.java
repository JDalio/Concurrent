package com.mda.thread.atom;

public class Increment
{
    private int i;
    private Object lock=new Object();

    public void increase()
    {
        synchronized (lock)
        {
            i++;
        }

    }

    public int getI()
    {
        return i;
    }

    public static void test(int threadNum,int loopTimes)
    {
        Increment increment=new Increment();

        Thread[] threads=new Thread[threadNum];

        for(int i=0; i<threads.length;i++)
        {
            Thread t=new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i=0;i<loopTimes;i++)
                    {
                        increment.increase();
                    }
                }
            });

            threads[i]=t;
            t.start();
        }

        for(Thread t:threads)
        {
            try
            {
                t.join();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Thread Num: "+threadNum+" Loop Times: "+loopTimes+" Result: "+increment.getI());
    }

    public static void main(String[] args)
    {
        test(20,5000);
    }
}
