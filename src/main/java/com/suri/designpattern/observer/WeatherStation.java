package com.suri.designpattern.observer;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class WeatherStation {

  public static void main(String[] args) {
    ISubject iSubject =  new WeatherData();
    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(iSubject);


    ((WeatherData) iSubject).setMeasurement(80,65,30.4f);
    ((WeatherData) iSubject).setMeasurement(82,70,29.4f);
    ((WeatherData) iSubject).setMeasurement(78,90,29.4f);
  }
}