package com.suri.leetcode.hard;

/**
 Write a program to solve a Sudoku puzzle by filling the empty cells.

 A sudoku solution must satisfy all of the following rules:

 Each of the digits 1-9 must occur exactly once in each row.
 Each of the digits 1-9 must occur exactly once in each column.
 Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 Empty cells are indicated by the character '.'.


 A sudoku puzzle...
 5 3 . . 7 . . . .
 6 . . 1 9 5 . . .
 . 9 8 . . . . 6 .
 8 . . . 6 . . . 3
 4 . . 8 . 3 . . 1
 7 . . . 2 . . . 6
 . 6 . . . . 2 8 .
 . . . 4 1 9 . . 5
 . . . . 8 . . 7 9


 ...and its solution numbers marked in red.
 5 3 4 6 7 8 9 1 2
 6 7 2 1 9 5 3 4 8
 1 9 8 3 4 2 5 6 7
 8 5 9 7 6 1 4 2 3
 4 2 6 8 5 3 7 9 1
 7 1 3 9 2 4 8 5 6
 9 6 1 5 3 7 2 8 4
 2 8 7 4 1 9 6 3 5
 3 4 5 2 8 6 1 7 9


 Note:

 The given board contain only digits 1-9 and the character '.'.
 You may assume that the given Sudoku puzzle will have a single unique solution.
 The given board size is always 9x9.
 */
public class Soln_37_Sudoku_Solver {
  static char [][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
  public static void main(String[] args) {

   solveSudoku(board);
    print(board);
  }

  public static void print(char [][] board){

    for(int i=0;i<board.length;i++){
      for(int j=0;j<board.length;j++){
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
  }


  private static final char EMPTY_ENTRY = '.';
  public static void solveSudoku(char[][] board) {
    System.out.println(canSolveSudoku(board,board.length));
  }

  public static boolean canSolveSudoku(char[][] board, int n){

    int row=-1;
    int col =-1;
    boolean isEmpty=false;
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(board[i][j]==EMPTY_ENTRY){
          row=i;
          col=j;
          isEmpty =true;
          break;
        }
      }
      if(isEmpty){
        break;
      }
    }

    if(!isEmpty){
      return true;
    }


    for(int num =1;num<=n;num++){

      char charToPlace = (char) (num + '0');

      if(isSafe(board,row,col,charToPlace)){

        board[row][col]= charToPlace;

        if(canSolveSudoku(board,n)){
          return true;
        }else{
          board[row][col] = EMPTY_ENTRY;
        }
      }
    }
    return false;
  }

  public static boolean isSafe(char [][] board, int row, int col, char charToPlace ){


    for(int r=0;r<board.length;r++){
      if(board[row][r]==charToPlace){
        return false;
      }
    }
    for(int c=0;c<board.length;c++){
      if(board[c][col]==charToPlace){
        return false;
      }
    }

    int sqrt = (int)Math.sqrt(board.length);

    int boxRowStart = row - row % sqrt;
    int boxColStart = col - col % sqrt;

    for(int i=boxRowStart;i<boxRowStart+sqrt;i++){
      for(int j=boxColStart;j<boxColStart+sqrt;j++){
        if(board[i][j]==charToPlace){
          return false;
        }
      }
    }
    return true;
  }
}