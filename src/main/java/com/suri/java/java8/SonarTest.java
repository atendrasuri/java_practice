package com.suri.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/05/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SonarTest {

    public static void main(String[] args) {


        List<Emplyee> list = new ArrayList<>();

        Optional<Emplyee> contractOpt= list.stream().findFirst();

        Emplyee res = contractOpt.orElseGet(Emplyee::new);
        System.out.println(res);
    }
}

class Emplyee{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emplyee{" +
                "name=" + name +
                '}';
    }
}