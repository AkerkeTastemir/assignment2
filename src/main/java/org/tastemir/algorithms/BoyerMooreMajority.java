package org.tastemir.algorithms;

import org.tastemir.metrics.PerformanceTracker;

public class BoyerMooreMajority {

    public int findMajority(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array cannot be null or empty");

        final int n = arr.length;

        // --- Fast paths ---
        if (n == 1) {
            tracker.incrementArrayAccesses();
            return arr[0];
        }
        if (n == 2) {
            tracker.incrementArrayAccesses();
            tracker.incrementArrayAccesses();
            tracker.incrementComparisons();
            if (arr[0] == arr[1]) return arr[0];
            throw new java.util.NoSuchElementException("No majority element");
        }

        // --- Phase 1: candidate ---
        int candidate = 0, count = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            tracker.incrementArrayAccesses();
            if (count == 0) {
                candidate = num;
                tracker.incrementAssignments();
                count = 1;
                tracker.incrementAssignments();
            } else {
                tracker.incrementComparisons();
                count += (num == candidate) ? 1 : -1;
                tracker.incrementAssignments();
            }
        }

        // --- Phase 2: verify with early-exit ---
        int occ = 0;
        for (int i = 0; i < n; i++) {
            tracker.incrementArrayAccesses();
            tracker.incrementComparisons();
            if (arr[i] == candidate) {
                occ++;
                if (occ > n / 2) return candidate;
            }
        }

        throw new java.util.NoSuchElementException("No majority element");
    }
}