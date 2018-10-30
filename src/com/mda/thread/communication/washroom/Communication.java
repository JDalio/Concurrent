package com.mda.thread.communication.washroom;

public class Communication
{
    public static void main(String[] args)
    {
        WashRoom washRoom=new WashRoom();

        new Thread(new ShitTask(washRoom,"狗哥"),"Dog-Thread").start();
        new Thread(new ShitTask(washRoom,"猫爷"),"Cat-Thread").start();
        new Thread(new ShitTask(washRoom,"王尼妹"),"Sister-Thread").start();

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        new Thread(new RepairTask(washRoom),"Repair-Thread").start();
    }

}
