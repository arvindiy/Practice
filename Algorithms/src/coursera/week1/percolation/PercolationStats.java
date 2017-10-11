package coursera.week1.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 *
 * @author akrishnaniyer
 */
public class PercolationStats {

    private final double[] percolationThresholds;
    
    private final int trials;
    private final double confidence;

    /**
     * perform trials independent experiments on an n-by-n grid
     *
     * @param n
     * @param trials
     */
    public PercolationStats(int n, int trials) {
        confidence = 1.96;
        this.trials = trials;
        this.percolationThresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            // System.out.println("-----------------------------------------------------Try No. " + i);
            Percolation per = new Percolation(n);
            int threshold = 0;
            while (!per.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                // System.out.println(row + " " + col);
                if (!per.isOpen(row, col)) {
                    per.open(row, col);
                    threshold++;
                    // System.out.println("Opened " + row + "," + col + ". Threshold =" + threshold);
                }
            }
            percolationThresholds[i] = (double) threshold / (double) (n * n);
        }
    }

    /**
     * sample mean of percolation threshold
     *
     * @return
     */
    public double mean() {
        return StdStats.mean(percolationThresholds);
    }

    /**
     * sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return StdStats.stddev(percolationThresholds);
    }

    /**
     * low endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceLo() {
        double mean = mean();
        double condifenceLo = mean - ((confidence * stddev()) / Math.sqrt(trials));
        return condifenceLo;
    }

    /**
     * high endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHi() {
        double mean = mean();
        // System.out.println("mean->" + mean);
        double condifenceHi = mean + ((confidence * stddev()) / Math.sqrt(trials));
        return condifenceHi;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        
        PercolationStats stats = new PercolationStats(n, t);

        System.out.println("mean\t\t\t = " + stats.mean());
        System.out.println("stddev\t\t\t = " + stats.stddev());
        System.out.println("95% confidence interval\t = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

}
