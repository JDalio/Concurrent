package com.mda.thread.communication.washroom;

public class RepairTask implements Runnable
{
    private WashRoom washRoom;

    public RepairTask(WashRoom washRoom)
    {
        this.washRoom = washRoom;
    }

    @Override
    public void run()
    {
        synchronized (washRoom.getLock())
        {
            System.out.println("Repairer get the washroom lock");
            System.out.println("Doing Repair work");

            try
            {
                Thread.sleep(5000L);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            washRoom.setAvailable(true);
            washRoom.getLock().notifyAll();
            System.out.println("Finish repairing");
        }
    }
}
