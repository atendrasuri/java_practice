package com.suri.dec26.subscriber.impl;

import com.suri.dec26.subscriber.DisplayElement;
import com.suri.dec26.alert.IAlert;
import com.suri.dec26.LogData;
import com.suri.dec26.SubscriberType;
import com.suri.dec26.subscriber.ISubscriber;

import java.util.List;

/**
 * SubscriberInfo implementation
 */
public class SubscriberInfo implements ISubscriber, DisplayElement {

  private IAlert alert;
  private SubscriberType type;
  private List<LogData> logDataList;

  public SubscriberInfo(IAlert alert) {
    this.alert = alert;
    type = SubscriberType.INFO;
    alert.registerSubscriber(this);
  }

  @Override
  public SubscriberType getType() {
    return type;
  }

  @Override
  public void update(List<LogData> logDataList) {
    this.logDataList = logDataList;
    synchronized (logDataList) {
      if (logDataList.size() >= 10) {
        logDataList.stream().filter(x -> x.getLogLevel().equalsIgnoreCase(SubscriberType.INFO.toString())).forEach(System.out::println);
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

  }

  @Override
  public void display() {
    logDataList.forEach(System.out::println);
  }


}