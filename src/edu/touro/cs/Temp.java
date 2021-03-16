package edu.touro.cs;

// TODO : Replace this file with your code

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MC
{
    public static List<Integer> syncList(List<Integer> list)
    {
        return new MyThreadSafeList(list);
    }
}

class MyTask implements Runnable
{
    public static List<Integer> list =
        MC.syncList(new ArrayList());

    @Override
    public void run()
    {
        for (int i =0;i<10_000_000;i++)
            list.add(i);
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
//        Thread t1 = new Thread(new MyRunnable()),
//               t2 = new Thread(new MyRunnable());
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println( MyRunnable.list.size());
//System.exit(0);



        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit( new MyTask() );
        es.submit( new MyTask() );

        es.shutdown();

        es.awaitTermination(10, TimeUnit.SECONDS);
//        while (! es.isTerminated())
//            Thread.sleep(100);// do nothing


        System.out.println( MyTask.list.size());
    }
}
