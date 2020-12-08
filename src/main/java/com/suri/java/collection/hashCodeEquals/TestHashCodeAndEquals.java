package com.suri.java.collection.hashCodeEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TestHashCodeAndEquals {
  public static void main(String[] args) {


    HashSet<Employee> employeeSet = new HashSet<>();

    Employee e1 = new Employee(1,"a");
    Employee e2 = new Employee(2,"b");
    Employee e3= new Employee(3,"c");
    Employee e4 = new Employee(1,"d");
    employeeSet.add(e1);
    employeeSet.add(e2);
    employeeSet.add(e3);
    employeeSet.add(e4);
    System.out.println(employeeSet.size());

    HashMap <Employee,String> employeeHashMap = new HashMap<>();
    employeeHashMap.put(e1,"E1");
    employeeHashMap.put(e2,"E2");
    employeeHashMap.put(e3,"E3");
    employeeHashMap.put(e4,"E4");
    e4.setId(5);
    System.out.println(employeeHashMap.size());


    HashSet<Person> personHashSet = new HashSet<>();
    Person p1 = new Person(1,"a");
    Person p2 = new Person(2,"b");
    Person p3 = new Person(3,"c");


    personHashSet.add(p1);
    personHashSet.add(p2);
    personHashSet.add(p3);

    Person h = new Person(1,"a");
    System.out.println(personHashSet.remove(h));
    System.out.println(personHashSet.size());

    Map<Person,String> personHashMap  = new HashMap<>();
    personHashMap.put(p1,"P1");
    personHashMap.put(p2,"P2");
    personHashMap.put(p3,"P3");
    personHashMap.remove(h);
    System.out.println(personHashMap.size());
  }
}