package com.suri.dec26.subscriber;

import com.suri.dec26.LogData;
import com.suri.dec26.SubscriberType;

import java.util.List;

/**
 * ISubscriber interface
 */
public interface ISubscriber {

   void update(List<LogData> logDataList);
   public SubscriberType getType();
}
