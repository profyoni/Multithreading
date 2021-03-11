package edu.touro.cs;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList implements List<Integer> {

    private int[] bs = new int[20_000_000];
    private int ip = 0;
    @Override
    public int size() {
        return ip;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
// synchronized
    // synchronized method - can only be accessed by one thread at a time
    // and all other synchronized methods on this object are thus locked
    // symchronized block - greater locking flexibility
    //                          (1) lock a few lines, not the whole method
    //                          (2) lock on a specific Object, not just on `this`
    // some methods may create a race condition if executed by one thread at
    // the same time another thread is executing some method (either this method
    // or another)
    // "writes" / modifying data may need to be protected
    // "reads" / getting data does not usually need to be protected

    // on entry thread obtains the "lock" for `this` object
    // on exit thread releases the lock for `this` object
    //   throws an exception is a form of exit

    // critical section - section of code that must be protected. Otherwise it
    // may lead to a race condition
    // degree of multithreading - how much multithreading do we allow to take place
    // lock granularity - fine granularity, coarse granulairty
    //                  - how small/large are the regions that are protected
    // fine granularity increases the degree of multithreading
    @Override
    public boolean add(Integer integer) {
        synchronized (this) {                   // t1           t2
            bs[ip] = integer;                   // 1-add 1     //4-add 2
            ip++;                               // 2-ip=1       //5 ip=2
        }
        // more instructions that are not part of a critical section
        return true;                        // 3            // 6
    }

    @Override
    public synchronized boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }
}
