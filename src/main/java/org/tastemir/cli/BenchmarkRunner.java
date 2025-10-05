package org.tastemir.cli;

import org.tastemir.algorithms.BoyerMooreMajority;
import org.tastemir.metrics.PerformanceTracker;

import java.util.Random;
import java.util.NoSuchElementException;

public class BenchmarkRunner {
    public static void main(String[] args) {
        BoyerMooreMajority algorithm = new BoyerMooreMajority();
        PerformanceTracker tracker = new PerformanceTracker();

        int[] sizes = {100, 1000, 10000};
        Random random = new Random();

        for (int size : sizes) {
            int[] arr = random.ints(size, 0, 3).toArray();

            try {
                int result = algorithm.findMajority(arr, tracker);
                System.out.println("Array size: " + size + " → Majority element: " + result);
            } catch (NoSuchElementException e) {
                System.out.println("Array size: " + size + " → No majority element found");
            }

            System.out.println(tracker);
            tracker.reset();
            System.out.println("-----");
        }
    }
}