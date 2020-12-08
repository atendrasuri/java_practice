package com.suri.designpattern.factory;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */

interface Vechicle {

    void drive();


}

class Car implements Vechicle {

    @Override
    public void drive() {
        System.out.println("I am under Car class");

    }
}

class MotorCycle implements Vechicle {

    @Override
    public void drive() {
        System.out.println("I am under Motorcycle");

    }
}

class VechicleFactory {


    public static Vechicle getVechicle(String vechicletype) {

        if ("Car".equalsIgnoreCase(vechicletype)) {
            return new Car();
        } else if ("MoterCycle".equalsIgnoreCase(vechicletype)) {
            return new MotorCycle();
        }
        return null;
    }
}


public class TestFactoryPattern {

    public static void main(String[] args) {


        Vechicle car = VechicleFactory.getVechicle("Car");
        car.drive();

        Vechicle motorcycle = VechicleFactory.getVechicle("MoterCycle");

        motorcycle.drive();
    }
}