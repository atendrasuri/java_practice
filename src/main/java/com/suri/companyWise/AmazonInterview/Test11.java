package com.suri.companyWise.AmazonInterview;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Test11 {

  public static void main(String[] args) {
/*Double decimalNumber = 1234.12;
    DecimalFormat df = new DecimalFormat("#.####");
//df.setMaximumFractionDigits(4);
    System.out.println(df.format(decimalNumber));*/
/*
    double amount = 12342.12;
    NumberFormat formatter = new DecimalFormat("#0.0000");
    System.out.println("The Decimal Value is:"+formatter.format(amount));
    double ss=new BigDecimal(formatter.format(amount));*/




Set set  = new HashSet();
set.add(null);
set.add("o");

    Iterator i = set.iterator();
    while(i.hasNext()){
      System.out.println(i.next());
    }



  }
}
