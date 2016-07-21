import io.agates.searching.BinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        //int[] a = {1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 6, 7};
        int[] a = {1, 2, 2, 2, 3, 3, 3, 3, 3, 3};
        List<Integer> array = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println("Array has majority value? " + BinarySearch.hastMajorityValue(array));

        /*for (int length = 1; length <= Math.pow(2, 16); length *= 2) {
            List<Integer> array = Arrays.stream(r.ints(length, 0, length).toArray())
                    .boxed()
                    .collect(Collectors.toList());
            //List<Integer> workList = new ArrayList<>(Collections.nCopies(array.size(), 0));

            BinarySearchTreeGraph<Integer, Integer> bst = new BinarySearchTreeGraph<>();

            for (Integer a :
                    array) {
                bst.insert(a, a);
            }

            Integer searchItem = array.get(array.size() / 2);
            Integer low = -100;
            Integer high = length + 100;

            System.out.println(searchItem + " exists: " + bst.lookup(searchItem).equals(searchItem));
            System.out.println(low + " (low) exists: " + (bst.lookup(low) != null));
            System.out.println(high + " (high) exists: " + (bst.lookup(high) != null));

            //Merge.bottomUpMergeSort(array, workList);

            //boolean sorted = isSorted(array);
            // TODO: Add some tests and timing information

            //int index = BinarySearch.binarySearchRecursive(array, searchItem);
            //int index = BinarySearch.binarySearchIterative(array, searchItem);
        }*/
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
