package io.agates.searching;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
}