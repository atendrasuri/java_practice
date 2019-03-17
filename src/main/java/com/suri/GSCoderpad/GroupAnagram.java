package com.suri.GSCoderpad; /**
 * Instructions to candidate.
 * 1) Given a list of words, group them by anagrams
 * Input: List of "cat", "dog", "god"
 * Output: A Set of Sets of anagrams: {{'cat'}, {'dog', 'god'}}
 * 2) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 3) Consider adding some additional tests in doTestsPass().
 * 4) Implement the AnagramSolution group() method correctly.
 * 5) If time permits, try to improve your implementation.
 */

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class GroupAnagram {

    /**
     * A means for grouping words by anagram (same letters irrespective of order)
     */
  /*@FunctionalInterface
  interface AnagramSolution {
    Set<Set<String>> group(List<String> words);
  }*/
    public Set<Set<String>> group(List<String> words) {


        Set<Set<String>> result1 = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> list;


        for (String word : words) {
            char chars[] = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new HashSet<>();
            }
            list.add(word);
            map.put(key, list);


        }
        for (String m : map.keySet()) {
            result1.add(map.get(m));

        }
        return result1;
    }

    /**
     * public static boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant

        // given some words
        List<String> words = Arrays.asList("cat", "dog", "god", "cat");

        // todo : and a solution to the problem
        GroupAnagram sol = new GroupAnagram();

        // when grouped
        Set<Set<String>> grouped = sol.group(words);

        // we expect god and dog to be identified as anagrams, whilst cat isn't
        boolean result = true;
        result = result && grouped.contains(new HashSet<>(Arrays.asList("cat")));
        result = result && grouped.contains(new HashSet<>(Arrays.asList("dog", "god")));
        return result;
    }

    ;


    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }

    }
}