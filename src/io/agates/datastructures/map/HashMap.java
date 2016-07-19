package io.agates.datastructures.map;

import io.agates.datastructures.tree.BinarySearchTreeGraph;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by agates on 7/12/16.
 */
public class HashMap<K extends Comparable<? super K>, V> implements Map<K, V> {
    private float fillRatio;

    private BinarySearchTreeGraph<K, V>[] buckets;

    public HashMap(int initialSize, float fillRatio) {
        this.fillRatio = fillRatio;

        buckets = (BinarySearchTreeGraph<K, V>[]) new BinarySearchTreeGraph[initialSize];
    }

    @Override
    public int size() {
        int size = 0;
        for (BinarySearchTreeGraph<K, V> o : buckets) {
            if (o != null) {
                size += o.getNumNodes();
            }
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;

        if (buckets[index] != null) {
            return buckets[index].lookup((K) key);
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;

        remove(key);

        if (buckets[index] == null) {
            buckets[index] = new BinarySearchTreeGraph<>();
        }

        buckets[index].insert(key, value);

        return value;
    }

    @Override
    public V remove(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;


        if (buckets[index] != null) {
            V temp = buckets[index].lookup((K) key);
            buckets[index].delete((K) key);
            return temp;
        }

        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
