package io.agates.datastructures.tree;

/**
 * Created by agates on 7/18/16.
 */
public class BinaryTreeNode<K extends Comparable<? super K>, V> {
    private K key;
    private V value;
    private BinaryTreeNode<K, V> left;
    private BinaryTreeNode<K, V> right;

    public BinaryTreeNode(K key, V value, BinaryTreeNode<K, V> left, BinaryTreeNode<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public BinaryTreeNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<K, V> left) {
        this.left = left;
    }

    public BinaryTreeNode<K, V> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<K, V> right) {
        this.right = right;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
