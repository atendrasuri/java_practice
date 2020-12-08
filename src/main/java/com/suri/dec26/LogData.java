package com.suri.dec26;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 26/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LogData {

  private String timeStamp;
  private String  logLevel;
  private String data;

  public LogData(String timeStamp, String logLevel, String data) {
    this.timeStamp = timeStamp;
    this.logLevel = logLevel;
    this.data = data;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "LogData{" +
            "timeStamp='" + timeStamp + '\'' +
            ", logLevel='" + logLevel + '\'' +
            ", data='" + data + '\'' +
            '}';
  }
}