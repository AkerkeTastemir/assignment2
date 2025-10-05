package org.tastemir.algorithms;

import org.tastemir.metrics.PerformanceTracker;

public class BoyerMooreMajority {

    public int findMajority(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int candidate = 0, count = 0;

        // Phase 1: Find candidate
        for (int num : arr) {
            tracker.incrementArrayAccesses();
            if (count == 0) {
                candidate = num;
                tracker.incrementAssignments();
            }
            tracker.incrementComparisons();
            count += (num == candidate) ? 1 : -1;
            tracker.incrementAssignments();
        }

        // Phase 2: Verify candidate
        count = 0;
        for (int num : arr) {
            tracker.incrementArrayAccesses();
            tracker.incrementComparisons();
            if (num == candidate) count++;
        }

        if (count > arr.length / 2) {
            return candidate;
        } else {
            throw new java.util.NoSuchElementException("No majority element found");
        }
    }
}