package io.agates.searching;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by agates on 7/9/16.
 */
public class BinarySearchTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test(expected=NullPointerException.class)
    public void binarySearchRecursiveNull() throws Exception {
        BinarySearch.binarySearchRecursive(null, 10);
    }

    @Test
    public void binarySearchRecursiveEmpty() throws Exception {
        List<Integer> a = new ArrayList<>();
        int index = BinarySearch.binarySearchRecursive(a, 10);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchRecursiveDoesNotExistLow() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }
        int index = BinarySearch.binarySearchRecursive(a, -1);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchRecursiveDoesNotExistHigh() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }
        int index = BinarySearch.binarySearchRecursive(a, 100);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchRecursiveOne() throws Exception {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        int index = BinarySearch.binarySearchRecursive(a, 10);

        assertEquals(index, 0);
    }

    @Test
    public void binarySearchRecursiveTwo() throws Exception {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        int index = BinarySearch.binarySearchRecursive(a, 20);

        assertEquals(index, 1);
    }

    @Test
    public void binarySearchRecursiveMany() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }
        int index = BinarySearch.binarySearchRecursive(a, a.get(50));

        assertEquals(index, 50);
    }

    @Test(expected=NullPointerException.class)
    public void binarySearchIterativeNull() throws Exception {
        BinarySearch.binarySearchIterative(null, 10);
    }

    @Test
    public void binarySearchIterativeEmpty() throws Exception {
        List<Integer> a = new ArrayList<>();
        int index = BinarySearch.binarySearchIterative(a, 10);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchIterativeDoesNotExistLow() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }
        int index = BinarySearch.binarySearchIterative(a, -1);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchIterativeDoesNotExistHigh() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }
        int index = BinarySearch.binarySearchIterative(a, 100);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchIterativeOne() throws Exception {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        int index = BinarySearch.binarySearchIterative(a, 10);

        assertEquals(index, 0);
    }

    @Test
    public void binarySearchIterativeTwo() throws Exception {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        int index = BinarySearch.binarySearchIterative(a, 20);

        assertEquals(index, 1);
    }

    @Test
    public void binarySearchIterativeMany() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }
        int index = BinarySearch.binarySearchIterative(a, a.get(50));

        assertEquals(index, 50);
    }

    @Test
    public void binarySearchFirstOccurrenceEmpty() throws Exception {
        List<Integer> a = new ArrayList<>();
        int index = BinarySearch.binarySearchFirstOccurrence(a, 10);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchFirstOccurrence() throws Exception {
        int[] array = {1, 2, 2, 3, 3, 3, 3, 3, 3, 5, 6, 7};
        List<Integer> a = Arrays.stream(array).boxed().collect(Collectors.toList());

        int index = BinarySearch.binarySearchFirstOccurrence(a, 3);

        assertEquals(index, 3);
    }

    @Test
    public void binarySearchFirstOccurrenceOddSize() throws Exception {
        int[] array = {1, 2, 2, 3, 3, 3, 3, 3, 3, 5, 6};
        List<Integer> a = Arrays.stream(array).boxed().collect(Collectors.toList());

        int index = BinarySearch.binarySearchFirstOccurrence(a, 3);

        assertEquals(index, 3);
    }

    @Test
    public void binarySearchFirstOccurrenceUnique() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }

        int index = BinarySearch.binarySearchFirstOccurrence(a, 50);

        assertEquals(index, 50);
    }

    @Test
    public void binarySearchLastOccurrenceEmpty() throws Exception {
        List<Integer> a = new ArrayList<>();
        int index = BinarySearch.binarySearchLastOccurrence(a, 10);

        assertEquals(index, -1);
    }

    @Test
    public void binarySearchLastOccurrence() throws Exception {
        int[] array = {1, 2, 2, 3, 3, 3, 3, 3, 3, 5, 6, 7};
        List<Integer> a = Arrays.stream(array).boxed().collect(Collectors.toList());

        int index = BinarySearch.binarySearchLastOccurrence(a, 3);

        assertEquals(index, 8);
    }

    @Test
    public void binarySearchLastOccurrenceOddSize() throws Exception {
        int[] array = {1, 2, 2, 3, 3, 3, 3, 3, 3, 5, 6};
        List<Integer> a = Arrays.stream(array).boxed().collect(Collectors.toList());

        int index = BinarySearch.binarySearchLastOccurrence(a, 3);

        assertEquals(index, 8);
    }

    @Test
    public void binarySearchLastOccurrenceUnique() throws Exception {
        List<Integer> a = new ArrayList<>();
        for (int c = 0; c < 100; ++c) {
            a.add(c);
        }

        int index = BinarySearch.binarySearchLastOccurrence(a, 50);

        assertEquals(index, 50);
    }
}