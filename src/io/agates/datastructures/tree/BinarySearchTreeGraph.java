package io.agates.datastructures.tree;

/**
 * Created by agates on 7/18/16.
 */
public class BinarySearchTreeGraph<K extends Comparable<? super K>, V> {
    private BinaryTreeNode<K, V> root;
    private int numNodes = 0;

    public BinarySearchTreeGraph() {
        root = null;
    }

    public void insert(K key, V value) {
        if (root == null) {
            root = new BinaryTreeNode<>(key, value, null, null);
        } else {
            insert(root, key, value);
        }
        ++numNodes;
    }

    private void insert(BinaryTreeNode<K, V> node, K key, V value) {
        if (node.getKey().equals(key)) {
            // maybe throw an exception or handle duplicate keys
            return;
        }

        if (key.compareTo(node.getKey()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(key, value, null, null));
            } else {
                insert(node.getLeft(), key, value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(key, value, null, null));
            } else {
                insert(node.getRight(), key, value);
            }
        }
    }

    public void delete(K key) {
        root = delete(root, key);
        --numNodes;
    }

    private BinaryTreeNode<K, V> delete(BinaryTreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        if (key.equals(node.getKey())) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }

            // Find the smallest node on the right side and make it the current node
            // This guarantees the order of our tree
            BinaryTreeNode<K, V> temp = smallestNode(node.getRight());
            node.setKey(temp.getKey());

            // Delete the "smallest node" since we've replaced it
            node.setRight(delete(node.getRight(), temp.getKey()));
            return node;
        } else if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(delete(node.getLeft(), key));
            return node;
        } else {
            node.setRight(delete(node.getRight(), key));
            return node;
        }
    }

    private BinaryTreeNode<K, V> smallestNode(BinaryTreeNode<K, V> node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return smallestNode(node.getLeft());
        }
    }

    public V lookup(K key) {
        return lookup(root, key);
    }

    private V lookup(BinaryTreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        if (node.getKey().equals(key)) {
            return node.getValue();
        }

        return key.compareTo(node.getKey()) < 0 ?
                lookup(node.getLeft(), key)
                : lookup(node.getRight(), key);
    }

    public int getNumNodes() {
        return numNodes;
    }
}
