package com.mda.thread.communication.restaurant;

import java.util.Queue;

public class Cook extends Thread
{
    private Queue<Food> queue;

    public Cook(Queue<Food> queue, String name)
    {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while (true)
        {
            SleepUtil.randomSleep();

            Food food = new Food();
            System.out.println(getName() + "生产了" + food);

            synchronized (queue)
            {
                while (queue.size() > 4)
                {
                    try
                    {
                        System.out.println("队列元素超5个: " + queue.size() + "  " + getName() + "抽烟等待中");
                        queue.wait();
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }

                queue.add(food);
                queue.notifyAll();
            }
        }
    }
}
