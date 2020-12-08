package com.suri.java.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */

interface LockCustom {

    void lock();

    void unlock();

    boolean tryLock();
}


class LockCustomImpl implements LockCustom {

    int lockHoldCount;
    long IdOfThreadCurrentlyHoldingLock;

    @Override
    public synchronized void lock() {

        if (lockHoldCount == 0) {
            lockHoldCount++;
            IdOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
        } else if (lockHoldCount > 0 && IdOfThreadCurrentlyHoldingLock == Thread.currentThread().getId()) {
            lockHoldCount++;
        } else {
            try {
                wait();
                lockHoldCount++;
                IdOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public synchronized void unlock() {

        if (lockHoldCount == 0) {
            throw new IllegalMonitorStateException();
        }

        lockHoldCount--;

        if (lockHoldCount == 0) {
            notifyAll();
        }

    }

    @Override
    public boolean tryLock() {
        if (lockHoldCount == 0) {
            lock();
            return true;
        }

        return false;
    }
}


class MyRunnable implements Runnable {
    LockCustom lockCustom;

    MyRunnable(LockCustom _lockCustom) {
        lockCustom = _lockCustom;
    }

    @Override
    public void run() {

        System.out.println("" + Thread.currentThread().getName() + "is waiting to acquire the lock");

        lockCustom.lock();
        System.out.println("" + Thread.currentThread().getName() + " has acquired the lock ");


        try {
            Thread.sleep(10000);

            System.out.println("" + Thread.currentThread().getName() + "is sleeping");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("" + Thread.currentThread().getName() + "has released the lock");
        lockCustom.unlock();

        lockCustom.tryLock();

    }
}

public class CustomLockTest {
    public static void main(String[] args) {

        ExecutorService ex = Executors.newFixedThreadPool(8);

        LockCustom lockcustom = new LockCustomImpl();

        MyRunnable myRunnable = new MyRunnable(lockcustom);

        new Thread(myRunnable, "Thread-1").start();
        new Thread(myRunnable, "Thread-2").start();

    }
}


