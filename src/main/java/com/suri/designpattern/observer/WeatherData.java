package com.suri.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class WeatherData implements ISubject {

  private List<IObserver> observers;

  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {
    this.observers = new ArrayList<>();
  }

  @Override
  public void registerObserver(IObserver iObserver) {

    observers.add(iObserver);
  }

  @Override
  public void removeObserver(IObserver iObserver) {
    int i = observers.indexOf(iObserver);
    if (i >= 0) {
      observers.remove(i);
    }

  }

  @Override
  public void notifyObserver() {
    observers.stream().forEach(x -> x.update(temperature, humidity, pressure));

  }

  public void measurementChanged() {
    notifyObserver();
  }

  public void setMeasurement(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementChanged();
  }
}