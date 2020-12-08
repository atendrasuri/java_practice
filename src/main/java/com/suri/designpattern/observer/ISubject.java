package com.suri.designpattern.observer;

/**
 * ISubject interface
 */
public interface ISubject {

   void registerObserver(IObserver iObserver);
   void removeObserver(IObserver iObserver);
   void notifyObserver();
}