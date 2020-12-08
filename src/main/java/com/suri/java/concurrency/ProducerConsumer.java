package com.suri.java.concurrency;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ProducerConsumer {
    private String value = "";
    private volatile boolean hasValue = false;
    public void produce(String value) {
        while (hasValue) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producing " + value + " as the next consumable");
        this.value = value;
        hasValue = true;
    }
    public String consume() {
        while (!hasValue) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String value = this.value;
        hasValue = false;
        System.out.println("Consumed " + value);
        return value;
    }
}

