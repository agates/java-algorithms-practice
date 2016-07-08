import io.agates.searching.BinarySearch;
import io.agates.sorting.Merge;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        for (int length = 1; length <= Math.pow(2, 16); length *= 2) {
            List<Integer> array = Arrays.stream(r.ints(length, 0, length).toArray())
                    .boxed()
                    .collect(Collectors.toList());
            List<Integer> workList = new ArrayList<>(Collections.nCopies(array.size(), 0));

            Integer searchItem = array.get(array.size() / 2);

            Merge.bottomUpMergeSort(array, workList);

            boolean sorted = isSorted(array);
            // TODO: Add some tests and timing information

            //int index = BinarySearch.binarySearchRecursive(array, searchItem);
            int index = BinarySearch.binarySearchIterative(array, searchItem);
        }
    }

    private static <T extends Comparable<T>> boolean isSorted(List<T> l) {
        for (int i = 1; i < l.size(); ++i) {
            if (l.get(i - 1).compareTo(l.get(i)) == 1) {
                return false;
            }
        }
        return true;
    }
}
