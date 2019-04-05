package com.suri.java.object;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class OverridingTest {

    public static void main(String[] args) {

       MyClass o1= new MyClass("Atendra",39);

        MyClass o2= new MyClass("Atendra",30);

        System.out.println(m(o1,o2));

    }

    public static String m(MyClass o1, MyClass o2) {
        String s1 = o1 == o2 ? "T" : "F";
        String s2 = o1.equals(o2) ? "T" : "F";
        String s3 = o1.hashCode() == o2.hashCode() ? "T" : "F";
        return s1 + s2 + s3;
    }
}

class MyClass{
    String name;
    int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        if (age != myClass.age) return false;
        return name != null ? name.equals(myClass.name) : myClass.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}

class AA
{
    int a=10;
}
class BB extends AA{

    int a=20;
}