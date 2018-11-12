package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/11/18
 * @Description: (Overwrite)
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * @History:
 */
public class LCSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        System.out.println(longestCommonSubsequence(X,Y));
    }

    public static int longestCommonSubsequence(char[] str1,char []str2){
        int m= str1.length;
        int n = str2.length;
        int L[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    L[i][j] =0;
                }
                else if(str1[i-1]==str2[j-1]){
                    L[i][j] = L[i-1][j-1]+1;
                }
                else{
                    L[i][j]= max(L[i-1][j],L[i][j-1]);
                }
            }
        }
        return L[m][n];
    }
    public static int max(int a, int b){
        return a>b?a:b;
    }
}
