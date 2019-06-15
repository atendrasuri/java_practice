package com.suri.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/06/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FinadAnyExample {

    public static void main(String[] args) {


        List<Employee> emp = new ArrayList<>();
        
        emp.add(new Employee(1,"A"));
        emp.add(new Employee(2,"B"));
        emp.add(new Employee(3,"C"));
        emp.add(new Employee(4,"D"));
        emp.add(new Employee(5,"E"));

        Employee res = emp.stream().filter(x -> x.getName().equals("F")).findAny().orElse(null);
        if(res==null){
            System.out.println("Hello");
        }

        System.out.println(res);
        
        
    }
}

class Employee{
    int age;
    String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}