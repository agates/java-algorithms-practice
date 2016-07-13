package io.agates.datastructures.map;

import groovy.util.MapEntry;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by agates on 7/12/16.
 */
public class HashMap<K, V> implements Map<K, V> {
    private float fillRatio;

    private LinkedList<Entry<K, V>>[] buckets;

    public HashMap(int initialSize, float fillRatio) {
        this.fillRatio = fillRatio;

        buckets = (LinkedList<Entry<K, V>>[]) new LinkedList[initialSize];
    }

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<Entry<K, V>> o : buckets) {
            if (o != null) {
                size += o.size();
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
            for (Entry<K, V> bucketEntry : buckets[index]) {
                if (bucketEntry.getKey().equals(key)) {
                    return bucketEntry.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;

        remove(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        buckets[index].push(new MapEntry(key, value));

        return value;
    }

    @Override
    public V remove(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;


        if (buckets[index] != null) {
            Entry<K, V> removeEntry = null;
            for (Entry<K, V> bucketEntry : buckets[index]) {
                if (bucketEntry.getKey().equals(key)) {
                    removeEntry = bucketEntry;
                    break;
                }
            }
            if (removeEntry != null) {
                buckets[index].remove(removeEntry);
                if (buckets[index].size() == 0) {
                    buckets[index] = null;
                }
                return removeEntry.getValue();
            }
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
