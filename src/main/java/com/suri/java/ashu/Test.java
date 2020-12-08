package com.suri.java.ashu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Hello","Lello","Billao", "hello");

        List<String> result = list.stream().
                sorted(
                        Comparator.comparing(String::toString, String.CASE_INSENSITIVE_ORDER)).
                collect(Collectors.toList());
        System.out.println(result);
    }
}
