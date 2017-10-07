
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author akrishnaniyer
 */
public class Percolation {

    private static final boolean FULL = false;
    private static final boolean OPEN = true;

    private final int n;
    private final WeightedQuickUnionUF gridUF;
    private boolean[][] grid;
    private int openSites;

    public Percolation(int n) {
        openSites = 0;
        if (n <= 0) {
            throw new IllegalArgumentException("N should be greater than 0.");
        }
        this.n = n;
        grid = new boolean[n][n];

        // We are using the extra 2 items for the top most virtual node
        // and the bottom nirtual node. These two nodes makes it easier for us
        // to check if the grid percolates or not.
        gridUF = new WeightedQuickUnionUF((this.n * this.n) + 2);
    }

    /**
     * Open the node, if not already open If the row is the top row, connect it
     * to the topmost virtual node If the row is the bottom row, connect it to
     * the bottommost virtual node Connect to the top row Connect to the bottom
     * row Connect to the left column Connect to the right column
     *
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        int zeroBasedRow = row - 1;
        int zeroBasedCol = col - 1;
        if (zeroBasedRow < 0 || zeroBasedRow > n-1 || zeroBasedCol < 0 || zeroBasedCol > n-1) {
            throw new IllegalArgumentException("The values should be between 1 and " + n);
        }

        grid[zeroBasedRow][zeroBasedCol] = OPEN;
        openSites++;

        // Connect to the topmost virtual node, if
        // row is first row (0)
        if (zeroBasedRow == 0) {
            gridUF.union(0, convertTo1D(zeroBasedRow, zeroBasedCol));
        }

        // Connect to the bottommost virtual node, if 
        // row is last row (n-1)
        if (zeroBasedRow == (n - 1)) {
            gridUF.union((n * n) + 1, convertTo1D(zeroBasedRow, zeroBasedCol));
        }

        // Connect to the bottom row
        if ((zeroBasedRow + 1) < n) {
            if (grid[zeroBasedRow + 1][zeroBasedCol] == OPEN) {
                gridUF.union(convertTo1D(zeroBasedRow, zeroBasedCol), convertTo1D(zeroBasedRow + 1, zeroBasedCol));
            }
        }

        // Connect to the top row
        if ((zeroBasedRow - 1) >= 0) {
            if (grid[zeroBasedRow - 1][zeroBasedCol] == OPEN) {
                gridUF.union(convertTo1D(zeroBasedRow, zeroBasedCol), convertTo1D(zeroBasedRow - 1, zeroBasedCol));
            }
        }

        // Connect to the right column
        if ((zeroBasedCol + 1) < n) {
            if (grid[zeroBasedRow][zeroBasedCol + 1] == OPEN) {
                gridUF.union(convertTo1D(zeroBasedRow, zeroBasedCol), convertTo1D(zeroBasedRow, zeroBasedCol + 1));
            }
        }

        // Connect to the left column
        if ((zeroBasedCol - 1) >= 0) {
            if (grid[zeroBasedRow][zeroBasedCol - 1] == OPEN) {
                gridUF.union(convertTo1D(zeroBasedRow, zeroBasedCol), convertTo1D(zeroBasedRow, zeroBasedCol - 1));
            }
        }

    }

    /**
     * This method would convert the 2D array into a 1D array, for the ufhelper
     * to locate the proper element In a 4X4 2D array, the 0-based index (2,2)
     * would be the 11th element in a one-dimensional array
     *
     * @param row
     * @param col
     * @return
     */
    private int convertTo1D(int i, int j) {
        return ((i * n) + j) + 1;
    }

    /**
     * is site (zeroBasedRow, zeroBasedCol) open?
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        int zeroBasedIndexRow = row - 1;
        int zeroBasedindexCol = col - 1;
        if (zeroBasedIndexRow < 0 || zeroBasedIndexRow > (n - 1) || zeroBasedindexCol < 0 || zeroBasedindexCol > (n - 1)) {
            throw new IllegalArgumentException("The values should be between 1 and " + n);
        }
        return grid[zeroBasedIndexRow][zeroBasedindexCol] == OPEN;
    }

    /**
     * is site (zeroBasedRow, zeroBasedCol) full?
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) {
        int zeroBasedIndexRow = row - 1;
        int zeroBasedindexCol = col - 1;
        if (zeroBasedIndexRow < 0 || zeroBasedIndexRow > (n - 1) || zeroBasedindexCol < 0 || zeroBasedindexCol > (n - 1)) {
            throw new IllegalArgumentException("The values should be between 1 and " + n);
        }
        return grid[zeroBasedIndexRow][zeroBasedindexCol] == FULL;
    }

    /**
     * Number of open sites
     *
     * @return
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * does the system percolate? Check if the topmost virtual node connects to
     * the bottom most virtual node
     *
     * @return
     */
    public boolean percolates() {
        return gridUF.connected(0, n * n + 1);
    }
}
