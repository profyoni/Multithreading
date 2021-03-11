package edu.touro.cs;

// TODO : Replace this file with your code

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

class MC
{
    public static List<Integer> syncList(List<Integer> list)
    {
        return new MyThreadSafeList(list);
    }
}
class MyThread extends Thread
{
    public static List<Integer> list =
            MC.syncList(new ArrayList());
    // dont maintain a reference to the ArrayList

    @Override
    public void run()
    {
        for (int i =0;i<10_000_000;i++)
            list.add(i);
    }
}

public class Temp {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread(),
               t2 = new MyThread();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println( MyThread.list.size());
    }
}
