package com.suri.dec26.alert;

import com.suri.dec26.subscriber.ISubscriber;

/**
 * ISubject interface
 */
public interface IAlert {

   void registerSubscriber(ISubscriber iSubscriber);
   void removeSubscriber(ISubscriber iSubscriber);
   void notifySubscriber();
}