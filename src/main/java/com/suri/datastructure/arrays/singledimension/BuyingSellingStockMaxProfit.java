package com.suri.datastructure.arrays.singledimension;



/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/04/19
 * @Description: (Overwrite)
 * Problem:
 * Given an array of stock prices,
 * find the maximum profit that can be earned by doing a single transaction of buy and sell in the given period of time.
 * @History:
 */
public class BuyingSellingStockMaxProfit {

    public static void main(String[] args) {

        int stocks[]= {100,80,120,130,70,60,100,125};

        System.out.println(" "+maximumProfit(stocks));

    }



    public static int maximumProfit(int stocks[]){


        int profit=0;
        int minimumPrice= Integer.MAX_VALUE;


        for(int i=0;i<stocks.length;i++ ){

            profit= Math.max(profit, stocks[i]-minimumPrice);
            minimumPrice= Math.min(minimumPrice, stocks[i]);
        }
        return profit;
    }
}