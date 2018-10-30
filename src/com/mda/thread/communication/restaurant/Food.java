package com.mda.thread.communication.restaurant;

public class Food
{
    private static int counter=0;
    private int i;

    public Food()
    {
        i=++counter;
    }

    @Override
    public String toString()
    {
        return "第"+i+"个菜";
    }
}
