package leet;

import java.util.HashSet;

/**
 * Solve a sudoku puzzle
 *
 * @author akrishnaniyer
 */
public class Sudoku {

    static int n = 9;

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char c = board[row][col];
                if (c != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    char c1 = (char) (k + '0');
                    System.out.println("trying " + row + " " + col + " " + c1);
                    board[row][col] = c1;
                    if (isValid(board, row, col) && solve(board)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<Character>();

        //Check if all the values in that column are 1-9
        for (int k = 0; k < n; k++) {
            char cs = board[row][k];

            if (set.contains(k)) {
                return false;
            }
            if (cs != '.') {
                set.add(cs);
            }
        }
        set.clear();

        //Check if all the values in that row are 1-9
        for (int k = 0; k < n; k++) {
            char cs = board[k][col];

            if (set.contains(k)) {
                return false;
            }
            if (cs != '.') {
                set.add(cs);
            }
        }
        set.clear();

        //Check if the 3x3 square contains the numbers 1-9
        /*
        There are 9 squares
        0,0 to 2,2
        0,3 to 2,5
        0,6 to 2,8
        
        2,0 to 4,2
        2,3 to 4,5
        2,6 to 4,8
        
        6,0 to 6,2
        6,3 to 6,5
        6,6 to 6,8
        
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = ((row / 3) * 3) + i;
                int y = ((col / 3) * 3) + j;
                char cs = board[x][y];

                if (set.contains(cs)) {
                    return false;
                }
                if (cs != '.') {
                    set.add(cs);
                }
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[][] grid = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '7', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '1'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("-------------BEFORE-------------");
        print(grid);

        solveSudoku(grid);

        System.out.println("-------------AFTER-------------");

        print(grid);
    }

    private static void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
