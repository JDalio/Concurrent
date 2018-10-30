package com.mda.thread.communication.restaurant;

import java.util.Queue;

public class Waiter extends Thread
{
    private Queue<Food>queue;

    public Waiter(Queue<Food>queue,String name)
    {
        super(name);
        this.queue=queue;
    }

    @Override
    public synchronized void start()
    {
        while (true)
        {
            Food food;
            synchronized (queue)
            {
                while (queue.size()<1)
                {
                    try
                    {
                        System.out.println("队列元素为: "+queue.size()+", "+getName()+"抽根烟等待中");
                        queue.wait();
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }

                food=queue.remove();
                System.out.println(getName()+" 获取到: "+food);
                queue.notifyAll();
            }

            SleepUtil.randomSleep();
        }

    }
}
