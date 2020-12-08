package com.suri.java.immutable;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Immutable {

  private final int value;

  public Immutable(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}