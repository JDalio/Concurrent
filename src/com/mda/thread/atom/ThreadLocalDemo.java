package com.mda.thread.atom;

public class ThreadLocalDemo
{
    public static ThreadLocal<String> THREAD_LOCAL=new ThreadLocal<String>()
    {

        @Override
        protected String initialValue()
        {
            return "Trigger initialValue";
        }
    };

    public static void main(String[] args)
    {
        ThreadLocalDemo.THREAD_LOCAL.set("Related to main thread");

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("t1 thread get value from ThreadLocal "+ThreadLocalDemo.THREAD_LOCAL.get());

                ThreadLocalDemo.THREAD_LOCAL.set("Related to t1 thread");

                System.out.println("t1 thread get value from ThreadLocal again "+ThreadLocalDemo.THREAD_LOCAL.get());

            }
        },"t1").start();

        System.out.println("main thread get value from ThreadLocal "+ThreadLocalDemo.THREAD_LOCAL.get());

    }
}
