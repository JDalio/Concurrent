package com.mda.thread.pooling;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Pool
{
    //serial
    public void process(List<Runnable> runnables)
    {
        for (Runnable r : runnables)
        {
            r.run();
        }
    }

    //assign single thread for every task
    public void process1(List<Runnable> runnables)
    {
        for (Runnable r : runnables)
        {
            new Thread(r).start();
        }
    }

    private void process2(List<Runnable> runnables)
    {
        final Queue<Runnable> queue = new ConcurrentLinkedDeque<>(runnables);
        for (int i = 0; i < 10; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    while (true)
                    {
                        Runnable r = queue.poll();
                        if (r == null)
                            break;
                        r.run();
                    }
                }
            }).start();
        }

    }

    //把任务的创建和执行解耦
    public interface Executor
    {
        void execute(Runnable command);
    }

//    public void process3(List<Runnable> runnables)
//    {
//        Executor executor = Executors.newFixedThreadPool(10);
//
//        for (Runnable r : runnables)
//        {
//            executor.execute(r);
//        }
//
//    }

    static class RunnableTest implements Runnable
    {

        @Override
        public void run()
        {
            System.out.println("Test Runnable Success");
        }
    }

    class ThreadPerRunnableExecutor implements Executor
    {

        @Override
        public void execute(Runnable command)
        {
            new Thread(command).run();
        }
    }

    class SerialExecutor implements Executor
    {

        @Override
        public void execute(Runnable command)
        {
            command.run();
        }
    }

/*    public interface Callable<V>
    {
        V call() throws Exception;
    }*/

    static class AddTask implements Callable<Integer>
    {
        private int i;
        private int j;

        public AddTask(int i,int j)
        {
            this.i=i;
            this.j=j;
        }


        @Override
        public Integer call() throws Exception
        {
            int sum=i+j;
            System.out.println("The result of add task: "+sum);
            return sum;
        }

    }


    public static void main(String[] args)
    {
        ExecutorService service=Executors.newCachedThreadPool();

        Future<Integer> future=service.submit(new AddTask(1,2));

        int result= 0;

        try
        {
            result = future.get();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        System.out.println("com.mda.thread.communication.washroom.Communication get result "+result);
    }
}
