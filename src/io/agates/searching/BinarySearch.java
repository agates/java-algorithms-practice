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

    public static <T extends Comparable<T>> int binarySearchFirstOccurrence(List<T> a, T item) {
        int lower = 0,
                upper = a.size() - 1,
                mid,
                comparison;

        while (lower <= upper) {
            // (lower + upper)/2 may have an arithmetic overflow for large lists
            // Looking for the beginning of the range will work fine with integer division
            mid = lower + (upper - lower) / 2;
            comparison = item.compareTo(a.get(mid));

            if (comparison > 0) {
                lower = mid + 1;
            } else if (comparison < 0) {
                upper = mid - 1;
            } else if (lower != mid) {
                // Rescan (increase) the search area until the lower index is the first occurrence
                upper = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static <T extends Comparable<T>> int binarySearchLastOccurrence(List<T> a, T item) {
        int lower = 0,
                upper = a.size() - 1,
                mid,
                comparison;

        while (lower <= upper) {
            // (lower + upper)/2 may have an arithmetic overflow for large lists
            // Since we are checking for the end of the range, we need to be sure to round up
            mid = (int) Math.ceil(lower + (upper - lower) / 2.0);
            comparison = item.compareTo(a.get(mid));

            if (comparison > 0) {
                lower = mid + 1;
            } else if (comparison < 0) {
                upper = mid - 1;
            } else if (upper != mid) {
                // Rescan (increase) the search area until the upper index is the last occurrence
                lower = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static <T extends Comparable<T>> boolean hastMajorityValue(List<T> a) {
        T middleElement = a.get(a.size() / 2);
        int lowerIndex = BinarySearch.binarySearchFirstOccurrence(a, middleElement);
        int upperIndex = BinarySearch.binarySearchLastOccurrence(a, middleElement);
        return ((upperIndex - lowerIndex + 1) / (double) a.size() * 100) > 50;
    }
}
