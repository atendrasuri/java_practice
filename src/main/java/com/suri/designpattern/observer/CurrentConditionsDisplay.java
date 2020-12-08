package com.suri.designpattern.observer;

/**
 * Observer implementation
 */
public class CurrentConditionsDisplay implements IObserver, DisplayElement {
  private float temperature;
  private float humidity;
  private ISubject weatherData;

  public CurrentConditionsDisplay(ISubject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }


  @Override
  public void update(float temperature, float humidity, float pressure) {


    this.temperature = temperature;
    this.humidity = humidity;
    display();


  }

  @Override
  public void display() {
    System.out.println(" Current condition is :- " + temperature + "F degree and " + humidity + "% humidity");
  }


}