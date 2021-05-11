package edu.touro.cs;

// TODO : Replace this file with your code

import java.util.*;
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
    private final int threadNum;

    MyTask(int threadNum)
    {
        this.threadNum = threadNum;
    }

    @Override
    public void run()
    {
        System.out.println(
               System.currentTimeMillis() + "Start :" + threadNum);
        double sleepTime = new Random().nextDouble() * 5 * 1_000;
        try {
            Thread.sleep((int)sleepTime);
        } catch (InterruptedException e) {}
        System.out.println(System.currentTimeMillis() + "Ended :" + threadNum);
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
        for (int i =0;i<10_000;i++)
            list.add(i);
    }
}

public class Temp {
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new MyTask()),
//               t2 = new Thread(new MyTask());
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println( MyTask.list.size());
//System.exit(0);



        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i=0;i<10;i++) {
            es.execute(new MyTask(i));
        }
        es.shutdown();

        es.awaitTermination(10, TimeUnit.HOURS);
//        while (! es.isTerminated())
//            Thread.sleep(100);// do nothing



    }
}
