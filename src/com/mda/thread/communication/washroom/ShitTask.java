package com.mda.thread.communication.washroom;

public class ShitTask implements Runnable
{
    private WashRoom washRoom;

    private String name;

    public ShitTask(WashRoom washRoom, String name)
    {
        this.washRoom = washRoom;
        this.name = name;
    }

    @Override
    public void run()
    {
        synchronized (washRoom.getLock())
        {
            System.out.println(name+" get the washroom lock");
            while(!washRoom.isAvailable())
            {
                try
                {
                    washRoom.getLock().wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println(name+" get out of the washroom");
        }
    }
}
