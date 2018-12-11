package com.suri.java.designpattern;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TestBuilderPattern {
    public static void main(String[] args) {

        Computer computer = new Computer.ComputerBuilder("500 GB", "2GB").build();

        System.out.println(""+computer);

        StringBuilder sb = new StringBuilder();
        sb.append("abc");

    }
}


class Computer {

    private String HD;
    private String RAM;

    /*
    optional arguments
     */
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public String getHD() {
        return HD;
    }



    public String getRAM() {
        return RAM;
    }


    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public Computer(ComputerBuilder builder) {
        this.HD = builder.HD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "HD='" + HD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    public static class ComputerBuilder{

          private String HD;
          private String RAM;

          /*
          optional arguments
           */
          private boolean isGraphicsCardEnabled;
          private boolean isBluetoothEnabled;

          public ComputerBuilder(String HD, String RAM) {
              this.HD = HD;
              this.RAM = RAM;
          }

          public ComputerBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
              isGraphicsCardEnabled = graphicsCardEnabled;
              return this;
          }

          public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
              isBluetoothEnabled = bluetoothEnabled;
              return this;
          }

          public Computer build(){
              return new Computer(this);
          }
      }

}