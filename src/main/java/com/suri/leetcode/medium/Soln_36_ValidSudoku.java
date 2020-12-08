package com.suri.leetcode.medium;

import java.util.HashSet;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 */
public class Soln_36_ValidSudoku {
  public static void main(String[] args) {

    char [][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    System.out.println(isValidSudoku(board));
  }
  public static boolean isValidSudoku(char[][] board) {

    HashSet<String> seen = new HashSet<>();

    for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
        char currentVal = board[i][j];

        if(currentVal !='.'){

          if((!seen.add(currentVal+"found at row"+i)) ||
                  (!seen.add(currentVal+"found at column"+j))||
                  (!seen.add(currentVal+"found in box "+i/3+""+j/3))){
            return false;
          }
        }
      }
    }
    return true;

  }
}