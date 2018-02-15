package leet.problem_51;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/description/

public class NQueens {

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        List<List<String>> solutions = obj.solveNQueens(8);
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allResultBoards = new ArrayList<List<String>>();
        List<String> resultBoard = new ArrayList<String>();

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        solveNQueens(board, 0);

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            resultBoard.add(i, sb.toString());
        }

        return allResultBoards;
    }

    /**
     * This is a method that would be called recursively for each column. We would
     * place the queen in one column, and then verify if it safe in that column. If
     * it is not safe, then we would attempt to backtrack and remove it from that
     * column, and try the next column.
     *
     * @param board
     * @param col
     * @return true if the board is solvable false, otherwise
     */
    private boolean solveNQueens(int[][] board, int col) {
        int n = board.length;
        if (col == n)
            return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueens(board, col + 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int board[][], int row, int col) {

        int n = board.length;

        // Check all the columns, in that 'row'
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check all the cols, in that 'col'
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check the lower left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;

    }
}
