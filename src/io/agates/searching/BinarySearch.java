package io.agates.searching;

import java.util.List;

/**
 * Created by agates on 7/8/16.
 * Binary search has an average and worst case performance of O(log n)
 * and a best case performance of O(1), although the best case is unlikely.
 * <p>
 * The worst case space complexity is O(1) for the iterative version
 * and O(log n) for the recursive version, due to the lack of tail call optimization
 */
public class BinarySearch {
    public static <T extends Comparable<T>> int binarySearchRecursive(List<T> a, T item) {
        return binarySearchRecursive(a, item, 0, a.size() - 1);
    }

    private static <T extends Comparable<T>> int binarySearchRecursive(List<T> a, T item, int lower, int upper) {
        if (lower > upper || upper >= a.size()) {
            return -1;
        }

        // (lower + upper)/2 may have an arithmetic overflow for large lists
        int mid = lower + (upper - lower) / 2,
                comparison = item.compareTo(a.get(mid));

        if (comparison == 0) {
            return mid;
        } else if (comparison > 0) {
            return binarySearchRecursive(a, item, mid + 1, upper);
        } else {
            return binarySearchRecursive(a, item, lower, mid - 1);
        }
    }

    public static <T extends Comparable<T>> int binarySearchIterative(List<T> a, T item) {
        int lower = 0,
                upper = a.size() - 1,
                mid,
                comparison;

        while (lower <= upper) {
            // (lower + upper)/2 may have an arithmetic overflow for large lists
            mid = lower + (upper - lower) / 2;
            comparison = item.compareTo(a.get(mid));

            if (comparison == 0) {
                return mid;
            } else if (comparison > 0) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        return -1;
    }
}
