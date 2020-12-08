package com.suri.dec26;

import com.suri.dec26.alert.IAlert;
import com.suri.dec26.alert.impl.Alert;
import com.suri.dec26.subscriber.ISubscriber;
import com.suri.dec26.subscriber.impl.SubscriberCritical;

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

/** TODO **/
public class AlertNotificationSystem {

  public static void main(String[] args) {
    IAlert iAlert =  new Alert();
    ISubscriber subscriber = new SubscriberCritical(iAlert);

    List<LogData>logDataList = new ArrayList<>();
    for(int i=0;i<=9;i++){
      logDataList.add(new LogData("2019-01-07 14:52:34","Critical","data"));
    }
    for(int i=0;i<=5;i++){
      logDataList.add(new LogData("2019-01-07 14:52:34","Warning","data"));
    }

    ((Alert) iAlert).insertLog(logDataList);

  }
}