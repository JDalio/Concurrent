package com.mda.thread.reordering;

public class Reordering
{
    private static boolean flag;
    private static int num;

    public synchronized static boolean isFlag()
    {
        return flag;
    }

    public synchronized static void setFlag(boolean flag)
    {
        Reordering.flag = flag;
    }

    public static void main(String[] args)
    {
        Thread t1=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(!isFlag())
                {
                    Thread.yield();
                }

                System.out.println(num);
            }
        },"t1");

        t1.start();

        num=5;
        setFlag(true);
    }

}
