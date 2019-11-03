package com.suri.designpattern.chainOfResponsibility;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 30/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class OddProcessor implements Chain {

  private Chain nextChain;
  @Override
  public void setNext(Chain chain) {

    nextChain = chain;
  }

  @Override
  public void process(Number request) {

    if(request.getNumber()%2!=0){
      System.out.println("Odd Processor "+request.getNumber());
    }else{
      nextChain.process(request);
    }

  }
}