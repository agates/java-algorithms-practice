package io.agates.datastructures.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by agates on 7/13/16.
 */
public class HashMapTest {
    private Map<String, Integer> h;

    @Before
    public void setUp() throws Exception {
        h = new HashMap<>(16, 0.75f);
    }

    @Test
    public void size() throws Exception {
        assertEquals(h.size(), 0);

        h.put("foo", 1);
        assertEquals(h.size(), 1);

        h.put("bar", 2);
        assertEquals(h.size(), 2);

        h.remove("bar");
        assertEquals(h.size(), 1);

        h.remove("foo");
        assertEquals(h.size(), 0);
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(h.isEmpty());

        h.put("foo", 1);
        assertFalse(h.isEmpty());

        h.remove("foo");
        assertTrue(h.isEmpty());
    }

    @Test
    public void containsKey() throws Exception {

    }

    @Test
    public void containsValue() throws Exception {

    }

    @Test
    public void get() throws Exception {
        h.put("foo", 1);
        assertTrue(h.get("foo") == 1);
    }

    @Test
    public void put() throws Exception {
        h.put("foo", 1);
        assertEquals(h.size(), 1);
        assertTrue(h.get("foo") == 1);

        h.put("foo", 2);
        assertEquals(h.size(), 1);
        assertTrue(h.get("foo") == 2);

        h.remove("foo");
        assertEquals(h.size(), 0);
    }

    @Test
    public void remove() throws Exception {
        h.put("foo", 1);
        h.put("bar", 2);
        assertTrue(h.remove("bar") == 2);
        assertNull(h.get("bar"));
    }

    @Test
    public void putAll() throws Exception {

    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void keySet() throws Exception {

    }

    @Test
    public void values() throws Exception {

    }

    @Test
    public void entrySet() throws Exception {

    }

}