import io.agates.sorting.merge;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        for (int length = 1; length < 1000; ++length) {
            List<Integer> array = Arrays.stream(r.ints(length, 0, length * 10).toArray())
                    .boxed()
                    .collect(Collectors.toList());

            merge.bottomUpMergeSort(array, new ArrayList<>(Collections.nCopies(array.size(), 0)));

            boolean sorted = isSorted(array);
            // TODO: Add some tests and timing information
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
