package com.suri.java.java8;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 01/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SortArrayJava8 {

    public static void main(String[] args) {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("after sort");
        listDevs.sort((Developer d1, Developer d2)->d1.getAge()-d2.getAge());

        listDevs.forEach(e-> System.out.println(e));

    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", 70000, 33));
        result.add(new Developer("alvin", 80000, 20));
        result.add(new Developer("jason", 100000, 10));
        return result;

    }
}

class Developer{

    String name;
    double sal;
    int age;
    public Developer(String name, double sal, int age) {
        this.name = name;
        this.sal = sal;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", age=" + age +
                '}';
    }



}