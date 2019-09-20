package com.suri.companyWise.AmazonInterview;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Supplier;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Tonmoy {
  public static void main(String[] args) throws ParseException {


    String iputDate ="2019-09-18T05:00:22.286-05:00";
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    sdf.setTimeZone(TimeZone.getTimeZone("CST"));

    Date d= sdf.parse(iputDate);

    SimpleDateFormat outputsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSz");
    outputsdf.setTimeZone(TimeZone.getTimeZone("IST"));
    System.out.println(outputsdf.format(d).replace("IST",""));


   /* public static final Supplier<LocalDate> getCurrentTimeOfSanghaiZone =
            () -> ZonedDateTime.now(ZoneId.of("Asia/Shanghai")).toLocalDate();*/

  }
}