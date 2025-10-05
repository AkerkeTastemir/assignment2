package org.tastemir.algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.tastemir.metrics.PerformanceTracker;

import java.util.NoSuchElementException;
import java.util.Random;

public class BoyerMooreMajorityTest {

    @Test
    void majorityExists_simple() {
        int[] arr = {2,2,1,2,3,2,2};
        var tracker = new PerformanceTracker();
        int res = new BoyerMooreMajority().findMajority(arr, tracker);
        Assertions.assertEquals(2, res);
    }

    @Test
    void noMajority_throws() {
        int[] arr = {1,2,3,1,2,3};
        var tracker = new PerformanceTracker();
        Assertions.assertThrows(NoSuchElementException.class,
                () -> new BoyerMooreMajority().findMajority(arr, tracker));
    }

    @Test
    void singleElement_isMajority() {
        int[] arr = {7};
        var tracker = new PerformanceTracker();
        int res = new BoyerMooreMajority().findMajority(arr, tracker);
        Assertions.assertEquals(7, res);
    }

    @Test
    void emptyArray_illegalArg() {
        int[] arr = {};
        var tracker = new PerformanceTracker();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BoyerMooreMajority().findMajority(arr, tracker));
    }

    @Test
    void forcedMajority_randomLarge() {
        int n = 10000;
        int majorityVal = 5;
        int majorityCount = n/2 + 1;

        int[] arr = new int[n];
        // заполним часть массива majority-значением
        for (int i = 0; i < majorityCount; i++) arr[i] = majorityVal;
        // остальное — случайные числа, отличные от majorityVal
        Random rnd = new Random(42);
        for (int i = majorityCount; i < n; i++) {
            int v;
            do { v = rnd.nextInt(10); } while (v == majorityVal);
            arr[i] = v;
        }

        var tracker = new PerformanceTracker();
        int res = new BoyerMooreMajority().findMajority(arr, tracker);
        Assertions.assertEquals(majorityVal, res);
    }
}