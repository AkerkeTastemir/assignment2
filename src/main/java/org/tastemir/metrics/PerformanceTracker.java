package org.tastemir.metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long arrayAccesses = 0;
    private long assignments = 0;

    public void incrementComparisons() { comparisons++; }
    public void incrementArrayAccesses() { arrayAccesses++; }
    public void incrementAssignments() { assignments++; }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getAssignments() { return assignments; }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
        assignments = 0;
    }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons +
                ", Array accesses: " + arrayAccesses +
                ", Assignments: " + assignments;
    }
}