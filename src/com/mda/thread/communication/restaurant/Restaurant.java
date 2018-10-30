package com.mda.thread.communication.restaurant;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant
{
    public static void main(String[] args)
    {
        Queue<Food> queue=new LinkedList<>();
        new Cook(queue,"cook1").start();
        new Cook(queue,"cook2").start();
        new Cook(queue,"cook3").start();

        new Waiter(queue,"waiter1").start();
        new Waiter(queue,"waiter2").start();
        new Waiter(queue,"waiter3").start();
    }
}
