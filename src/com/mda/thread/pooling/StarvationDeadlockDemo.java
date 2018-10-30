package com.mda.thread.pooling;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StarvationDeadlockDemo
{
    private static ExecutorService service = Executors.newSingleThreadExecutor();

    private static class Task1 implements Callable<String>
    {

        @Override
        public String call() throws Exception
        {
            System.out.println("Start executing task1");
            Future<String> future = service.submit(new Task2());
            System.out.println("The result of task2 is " + future.get());
            return "task1";
        }
    }

    private static class Task2 implements Callable<String>
    {

        @Override
        public String call() throws Exception
        {
            System.out.println("Start running task2");
            return "task2";
        }
    }

    public static void main(String[] args)
    {
        service.submit(new Task1());
    }
}
