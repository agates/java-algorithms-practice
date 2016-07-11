package io.agates.sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by agates on 7/10/16.
 */
public class MergeTest {
    private int size = 32;

    private List<Integer> a;
    private List<Integer> workList;
    private Random r = new Random(System.nanoTime());

    private static <T extends Comparable<? super T>> boolean isSorted(List<T> l) {
        for (int i = 1; i < l.size(); ++i) {
            if (l.get(i - 1).compareTo(l.get(i)) == 1) {
                return false;
            }
        }
        return true;
    }

    @Before
    public void setUp() throws Exception {
        workList = new ArrayList<>(Collections.nCopies(size, 0));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void topDownMergeSort() throws Exception {
        a = Arrays.stream(r.ints(size, 0, size).toArray())
                .boxed()
                .collect(Collectors.toList());

        Merge.topDownMergeSort(a, workList);
        assertEquals(isSorted(a), true);
    }

    @Test
    public void topDownMergeSortEmpty() throws Exception {
        a = new ArrayList<>();

        Merge.topDownMergeSort(a, workList);
        assertEquals(a.size(), 0);
    }

    @Test(expected = InsufficientWorklistSizeException.class)
    public void topDownMergeSortSmallWorklist() throws Exception {
        a = new ArrayList<>(Collections.nCopies(size, 0));

        workList.remove(workList.size() - 1);
        Merge.topDownMergeSort(a, workList);
    }

    @Test
    public void bottomUpMergeSort() throws Exception {
        a = Arrays.stream(r.ints(size, 0, size).toArray())
                .boxed()
                .collect(Collectors.toList());

        Merge.bottomUpMergeSort(a, workList);
        assertEquals(isSorted(a), true);
    }

    @Test
    public void bottomUpMergeSortEmpty() throws Exception {
        a = new ArrayList<>();

        Merge.bottomUpMergeSort(a, workList);
        assertEquals(a.size(), 0);
    }

    @Test(expected = InsufficientWorklistSizeException.class)
    public void bottomUpMergeSortSmallWorklist() throws Exception {
        a = new ArrayList<>(Collections.nCopies(size, 0));

        workList.remove(workList.size() - 1);
        Merge.bottomUpMergeSort(a, workList);
    }
}