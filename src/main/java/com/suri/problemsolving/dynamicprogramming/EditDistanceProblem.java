package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 02/08/19
 * @Description: (Overwrite)
 * Minimum Edit distance between two strings str1 and str2 is defined as the minimum number of insert/delete/substitute operations required to transform str1 into str2.
 * For example if str1 = "ab", str2 = "abc" then making an insert operation of character 'c' on str1 transforms str1 into str2. Therefore, edit distance between str1 and str2 is 1.
 * You can also calculate edit distance as number of operations required to transform str2 into str1.
 * For above example, if we perform a delete operation of character 'c' on str2, it is transformed into str1 resulting in same edit distance of 1.
 * <p>
 * Looking at another example, if str1 = "INTENTION" and str2 = "EXECUTION", then the minimum edit distance between str1 and str2 turns out to be 5 as shown below.
 * All operations are performed on str1.
 * @History:
 */
public class EditDistanceProblem {

    public static void main(String[] args) {

        String str1= "SATURDAY";
        String str2 = "SUNDAY";

        System.out.println(findEditDistance(str1,str2));

    }


    public static int findEditDistance(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m + 1][n + 1];


        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {

                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}