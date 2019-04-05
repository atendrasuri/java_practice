package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 30/03/19
 * @Description: (Overwrite)
 *
 *
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 * For example, b|anana, required one cut to make it palindrome.
 * @History:
 */
public class PalindromePartitionMinCut {

    public static int minCutsPalindrome(String str){

        int n= str.length();

        boolean palindrome[][] = new boolean[n][n];

        // trivial case because every character of a string is palindrome to itself
        for(int i=0;i<n;i++){
            palindrome[i][i]= true;
        }

        // for every two characters
        for(int i=0;i<n-1;i++){

            if(str.charAt(i)==str.charAt(i+1)){
                palindrome[i][i+1]=true;
            }
        }

        // for remaining characters starting from 3rd
        for(int curr_len=3;curr_len<=n;curr_len++){

            for(int i=0;i<n-curr_len+1;i++){
                int j= i+curr_len-1;

                if(str.charAt(i)==str.charAt(j)&& palindrome[i+1][j-1]){
                    palindrome[i][j]=true;
                }
            }
        }

        int cuts[]= new int[n];

        for(int i=0;i<n;i++){

            int temp= Integer.MAX_VALUE;

            if(palindrome[0][i]){
                cuts[i]=0;
            }else{

                for(int j=0;j<i;j++){
                    if(palindrome[j+1][i] && temp>cuts[j]+1){
                        temp= cuts[j]+1;
                    }
                }
                cuts[i]=temp;
            }


        }
        return cuts[n-1];
    }

    public static void main(String[] args) {

        System.out.println(minCutsPalindrome("BANANA"));

    }
}