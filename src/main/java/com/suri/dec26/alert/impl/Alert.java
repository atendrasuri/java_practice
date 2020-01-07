package com.suri.dec26.alert.impl;

import com.suri.dec26.LogData;
import com.suri.dec26.SubscriberType;
import com.suri.dec26.alert.IAlert;
import com.suri.dec26.subscriber.ISubscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Alert implements IAlert {

  List<LogData> logDataList = new ArrayList<>();
  private List<ISubscriber> iSubscriberList;

  public Alert() {
    this.iSubscriberList = new ArrayList<>();
  }

  @Override
  public void registerSubscriber(ISubscriber iSubscriber) {

    iSubscriberList.add(iSubscriber);
  }

  @Override
  public void removeSubscriber(ISubscriber iSubscriber) {

    int i = iSubscriberList.indexOf(iSubscriber);
    if (i >= 0) {
      iSubscriberList.remove(i);
    }
  }

  @Override
  public void notifySubscriber() {

    iSubscriberList.forEach(x -> x.update(logDataList));

  }


  public void logChanged() {
    notifySubscriber();
  }

  public void insertLog(List<LogData> logDataList) {
    this.logDataList = logDataList;
    logChanged();
  }


}