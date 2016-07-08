package io.agates.sorting;

import java.util.List;

/**
 * Created by agates on 7/7/16.
 * <p>
 * Merge sort uses O(n log n) time and O(n) external space for both
 * best, average and worst case.
 * <p>
 * For this reason it is useful for
 */
public class merge {
    public static <T extends Comparable<T>> void topDownMergeSort(List<T> a, List<T> workList) {
        if (workList.size() < a.size()) {
            // worklist is not large enough to hold the list data
            return;
        }
        topDownSplitMerge(a, 0, a.size(), workList);
    }

    private static <T extends Comparable<T>> void topDownSplitMerge(List<T> a, int begin, int end, List<T> b) {
        if (end - begin < 2) {
            return;
        }

        int middle = (end + begin) / 2;
        topDownSplitMerge(a, begin, middle, b);
        topDownSplitMerge(a, middle, end, b);

        mergeLists(a, begin, middle, end, b);

        for (int i = begin; i < end; ++i) {
            a.set(i, b.get(i));
        }
    }


    public static <T extends Comparable<T>> void bottomUpMergeSort(List<T> a, List<T> workList) {
        if (workList.size() < a.size()) {
            // worklist is not large enough to hold the list data
            return;
        }
        bottomUpSplitMerge(a, workList);
    }

    private static <T extends Comparable<T>> void bottomUpSplitMerge(List<T> a, List<T> b) {
        int n = a.size();
        boolean swapped = false;
        List<T> temp = b;
        // divide list into subsections
        // width = 1, 2, 4, 8...
        // once a subsection is merged, the subsection size doubles
        // until we can no longer double it.
        int width;
        for (width = 1; width < a.size(); width *= 2, swapped = !swapped) {
            // iterate through every two subsections
            for (int i = 0; i < n; i += 2 * width) {
                // Merge each set of two subsections
                // i = current left position
                // i + width = current mid position (or the end of the list)
                // i + w * width = current right position (or the end of the list)
                mergeLists(a, i, Math.min(i + width, n), Math.min(i + 2 * width, n), b);
            }

            // since b is already sorted, swap a and b
            b = a;
            a = temp;
            temp = b;
        }

        // An uneven amount of runs means the lists are in the wrong position
        // we need to copy the data back to the original
        // this happens for data sets that have lengths > even powers of two but <= odd powers of two
        if (swapped) {
            for (int i = 0; i < n; ++i) {
                b.set(i, a.get(i));
            }
        }
    }

    private static <T extends Comparable<T>> void mergeLists(List<T> a, int begin, int middle, int end, List<T> b) {
        int i = begin, j = middle;

        for (int k = begin; k < end; ++k) {
            // if left side is not empty (
            if (i < middle && (j >= end || a.get(i).compareTo(a.get(j)) <= 0)) {
                b.set(k, a.get(i));
                ++i;
            } else {
                b.set(k, a.get(j));
                ++j;
            }
        }
    }


    public static void topDownMergeSort(int[] a) {
        topDownSplitMerge(a, 0, a.length, new int[a.length]);
    }

    private static void topDownSplitMerge(int[] a, int begin, int end, int[] b) {
        if (end - begin < 2) {
            return;
        }

        int middle = (end + begin) / 2;
        topDownSplitMerge(a, begin, middle, b);
        topDownSplitMerge(a, middle, end, b);
        mergeLists(a, begin, middle, end, b);

        System.arraycopy(b, begin, a, begin, end - begin);
    }

    private static void mergeLists(int[] a, int begin, int middle, int end, int[] b) {
        int i = begin, j = middle;

        for (int k = begin; k < end; ++k) {
            if (i < middle && (j >= end || a[i] <= a[j])) {
                b[k] = a[i];
                ++i;
            } else {
                b[k] = a[j];
                ++j;
            }
        }
    }
}
