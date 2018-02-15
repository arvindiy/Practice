package leet.problem_36;

import java.util.HashSet;

public class ValidSudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
         * char[][] grid = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6',
         * '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.',
         * '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.',
         * '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.',
         * '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.',
         * '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9'
         * } };
         */
        char[][] grid = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        System.out.println("-------------BEFORE-------------");

        print(grid);

        System.out.println(new ValidSudoku().isValidSudoku(grid));

    }

    private static void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    /**
     * This method determines if the given board is valid. the intent is not to
     * solve it
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int rows = 9;
        int cols = 9;

        HashSet<Character> set = new HashSet<Character>();

        // Check Each Row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c))
                        return false;
                    set.add(c);
                }
            }
            set.clear();
        }

        // Check each col
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (set.contains(c))
                        return false;
                    set.add(c);
                }
            }
            set.clear();
        }

        // Check every 3*3 matrix

        for (int i = 0; i < rows; i++) {// 9 3*3 matrices
            int startingIndex = (i / 3) * 3;
            //System.out.println("BLock # ---> " + i + " _ " + startingIndex);
            for (int j = startingIndex; j < startingIndex + 3; j++) {
                for (int k = i % 3 * 3; k < i % 3 * 3 + 3; k++) {
                    char c = board[j][k];
                    System.out.println(c);
                    if (c != '.') {
                        if (set.contains(c))
                            return false;
                        //System.out.println("Added " + c);
                        set.add(c);
                    }
                }
            }
            set.clear();
        }
        return true;
    }
}
