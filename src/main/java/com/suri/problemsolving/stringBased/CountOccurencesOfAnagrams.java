package com.suri.problemsolving.stringBased;

import java.util.Arrays;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/08/19
 * @Description: (Overwrite)
 * Given a word and a text, return the count of the occurences of anagrams of the word in the text(For eg: anagrams of word for are for, ofr, rof etc.))
 *
 * Examples:
 *
 * Input : forxxorfxdofr
 *         for
 * Output : 3
 * Explanation : Anagrams of the word for - for, orf,
 * ofr appear in the text and hence the count is 3.
 *
 * Input : aabaabaa
 *         aaba
 * Output : 4
 * Explanation : Anagrams of the word aaba - aaba,
 * abaa each appear twice in the text and hence the
 * count is 4
 * @History:
 */
public class CountOccurencesOfAnagrams {

  public static void main(String[] args) {
    String text = "forxxorfxdofr";
    String word = "for";
    System.out.print(countAnagrams(text, word));

  }
  public static boolean areAnagram(String s1, String s2){

    char [] ch1 = s1.toCharArray();
    char [] ch2 = s2.toCharArray();

    Arrays.sort(ch1);
    Arrays.sort(ch2);

    if(Arrays.equals(ch1,ch2)){
      return true;
    }else{
    return false;}

  }

  public static int countAnagrams(String text, String word){

    int n = word.length();
    int N = text.length();
    int res=0;

    for(int i=0;i<=N-n;i++){

      String s = text.substring(i,i+n);
      if(areAnagram(word,s)){
        res++;
      }
    }
    return res;
  }
}