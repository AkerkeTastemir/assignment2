package org.tastemir.cli;

import org.tastemir.algorithms.BoyerMooreMajority;
import org.tastemir.metrics.PerformanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        int[] sizes = {100, 1000, 10000, 100000};
        Random random = new Random(123);

        File outDir = new File("docs/performance-plots");
        outDir.mkdirs();
        File csv = new File(outDir, "majority_benchmark.csv");

        try (PrintWriter pw = new PrintWriter(new FileWriter(csv))) {
            pw.println("n,hasMajority,timeNs,comparisons,arrayAccesses,assignments");

            BoyerMooreMajority algo = new BoyerMooreMajority();
            PerformanceTracker tracker = new PerformanceTracker();

            for (int n : sizes) {
                int[] arr = random.ints(n, 0, 3).toArray(); // случайный набор 0..2
                // при желании: сделать второй прогон с гарантированным большинством

                long t0 = System.nanoTime();
                boolean hasMaj = true;
                try {
                    algo.findMajority(arr, tracker);
                } catch (NoSuchElementException ex) {
                    hasMaj = false;
                }
                long t1 = System.nanoTime();

                pw.printf("%d,%b,%d,%d,%d,%d%n",
                        n, hasMaj, (t1 - t0),
                        tracker.getComparisons(),
                        tracker.getArrayAccesses(),
                        tracker.getAssignments());

                // печать в консоль для наглядности
                System.out.printf("n=%d -> hasMajority=%b, time=%.3f ms, %s%n",
                        n, hasMaj, (t1 - t0)/1e6, tracker.toString());

                tracker.reset();
            }
        }

        System.out.println("CSV written to: " + csv.getPath());
    }
}