package com.suri.java.concurrency.lock;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * The ReentrantLock class implements the Lock interface and provides synchronization to methods while accessing shared resources.
 * The code which manipulates the shared resource is surrounded by calls to lock and unlock method.
 * This gives a lock to the current working thread and blocks all other threads which are trying to take a lock on the shared resource.
 *
 * As the name says, ReentrantLock allow threads to enter into lock on a resource more than once. When the thread first enters into lock, a hold count is set to one. Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one. For every unlock request,
 * hold count is decremented by one and when hold count is 0, the resource is unlocked.
 *
 * Reentrant Locks also offer a fairness parameter, by which the lock would abide by the order of the lock request i.e. after a thread unlocks the resource, the lock would go to the thread which has been waiting for the longest time. This fairness mode is set up by passing true to the constructor of the lock.
 */
public class ReentrantLockTest {
  ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {

    Map map;

  }
}