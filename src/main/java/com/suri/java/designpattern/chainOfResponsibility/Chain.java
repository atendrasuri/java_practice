package com.suri.java.designpattern.chainOfResponsibility;

public interface Chain {

  void setNext(Chain chain);

  void process(Number request);


}
