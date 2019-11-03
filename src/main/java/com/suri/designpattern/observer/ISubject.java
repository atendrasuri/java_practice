package com.suri.designpattern.observer;

/**
 * ISubject interface
 */
public interface ISubject {

  public void registerObserver(IObserver iObserver);
  public void removeObserver(IObserver iObserver);
  public void notifyObserver();
}