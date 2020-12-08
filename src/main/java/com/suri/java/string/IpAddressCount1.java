package com.suri.java.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/01/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
class IpAddressCount1 {

    public static void main(String[] args) {

        String str = "10.0.0.2,10.0.1.2-10.0.1.2,10.0.0.2 10.0.0.3";

        String ipsarr[] = str.split(",|-| ");


        Map<String, Integer> ips = new HashMap<>();


        for (String ip : ipsarr) {
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