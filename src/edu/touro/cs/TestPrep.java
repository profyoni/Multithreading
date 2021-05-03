package edu.touro.cs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@FunctionalInterface // has one method
interface Operation
{
    int doSomething(int a, int b);
}

@FunctionalInterface // has one method
interface OperationOneArg
{
    int doSomething(int a);
}

interface Operation2
{
    int doSomething(int a, int b);
}

// you give 2 I give 1

class Add implements Operation
{
    public int doSomething(int x, int y){
        return x + y;
    }
}
class Mult implements Operation
{
    public int doSomething(int x, int y){
        return x * y;
    }
}

class MyUtilityBelt
{
    static int[] Process(int[]list1, int[]list2, Operation op)
    {   // 1 2 4
        // 6 3 1
        // 7 5 5
        int [] ret = new int[list1.length];
        for(int i=0;i<ret.length;i++)
        {
            ret[i] = op.doSomething(list1[i],list2[i]);
        }
        return ret;
    }
}

public class TestPrep {
    public static void main(String[] args) {
        new MagicNumber();
        Operation myop = (i, j) -> i + j;

        Operation2 myop2 = (i, j) -> i * j;
        OperationOneArg myop3 = new OperationOneArg() {
            @Override
            public int doSomething(int x) {
                return x * x;
            }
        };

        myop = new Add();


        myop = (thing1, thing2) -> thing1 * thing2;

        int[]list1 = new int[]{1,4,7},
             list2 = new int[]{9,5,3};
        int[] list3 = MyUtilityBelt.Process(list1, list2,
                (x,y)->x*y );
        System.out.println(list3[0]);

    }
}

class MagicNumber extends JFrame
{
    private JButton b = new JButton("Press");
    private JTextArea a = new JTextArea(200, 20);
    int num = 0;
    public MagicNumber()
    {
        setTitle("Magic Number");
        setSize(500,500);
        setDefaultCloseOperation(3);
        add(b, BorderLayout.NORTH);
        add((a), BorderLayout.CENTER);
        b.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Thread t = new Thread(){
                            @Override
                            public void run() {
                                int number = num++;
                                for (int i=0;i<5;i++)
                                {

                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException interruptedException){}
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            a.append(number + "\n");
                                        }
                                    });

                                }
                            }
                        };
                        t.start();
                    }
                }
        );
        setVisible(true);
    }
}
