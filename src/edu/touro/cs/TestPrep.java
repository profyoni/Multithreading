package edu.touro.cs;

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
        Operation myop = (i, j) -> i + j;
        Operation2 myop2 = (i, j) -> i * j;
        OperationOneArg myop3 = x -> x*x;

        myop = new Add();


        myop = (thing1, thing2) -> thing1 * thing2;

        int[]list1 = new int[]{1,4,7},
             list2 = new int[]{9,5,3};
        int[] list3 = MyUtilityBelt.Process(list1, list2,
                (x,y)->x*y );
        System.out.println(list3[0]);
    }
}


