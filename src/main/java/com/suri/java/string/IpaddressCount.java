package com.suri.java.string;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 10/01/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class IpaddressCount {

    public static void main(String[] args) {

        String str = "10.0.3.1 and other ip 10.0.3.1 and 10.0.1.1 ip 10.0.0.2 next 10.0.0.1 and 10.0.1.1";

        Pattern pattern =
                Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");


        Map<String, Integer> ips = new HashMap<String, Integer>();
        Matcher match = pattern.matcher(str);

        while (match.find()) {
            String ip = match.group();

            if (ips.get(ip) != null) {
                ips.put(ip, ips.get(ip) + 1);
            } else {
                ips.put(ip, 1);
            }
        }

        int max = getMaxOccurance(ips);
        for (Map.Entry<String, Integer> ip : ips.entrySet()) {
            if (ip.getValue() == max) {
                System.out.println(ip.getKey());
            }
        }

    }


    static int getMaxOccurance(Map<String, Integer> ips) {

        int max = 1;

        for (Map.Entry<String, Integer> ip : ips.entrySet()) {
            if (ip.getValue() > max) {
                max = ip.getValue();
            }
        }
        return max;
    }
}