package com.suri.java.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class RearrangeWord {

    public static void main(String[] args) {

        String str1 = "Lovingss my i coding.";

        System.out.println(reArrange(str1));

    }


    public static String reArrange(String sentence) {
        String str1 = sentence.replace('.', ' ');

        String words[] = str1.split(" ");
        int n = words.length;

        Arrays.sort(words, new StringCompartor());

        StringBuilder finalString = new StringBuilder();
        finalString.append(lowertoUpper(words[0]));

        for (int i = 1; i < n; i++) {
            finalString.append(" " + uppertoLower(words[i]));
        }
        finalString.append(".");


        return finalString.toString();
    }

    public static String uppertoLower(String s) {
        int c = s.charAt(0);
        int c1 = 0;
        if (c >= 65 && c < 91) {
            c1 = c + 32;
        } else {
            c1 = c;
        }
        return s.replace((char) c, (char) c1);
    }

    public static String lowertoUpper(String s) {
        int c = s.charAt(0);
        int c1 = 0;
        if (c >= 97 && c < 122) {
            c1 = c - 32;
        } else {
            c1 = c;
        }
        return s.replace((char) c, (char) c1);

    }
}

class StringCompartor implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

}