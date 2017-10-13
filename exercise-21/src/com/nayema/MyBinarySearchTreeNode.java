package com.nayema;

public class MyBinarySearchTreeNode<E> {
    public E value;
    public int key = 0;
    public MyBinarySearchTreeNode leftChild;
    public MyBinarySearchTreeNode rightChild;

    public MyBinarySearchTreeNode(int key, E value) {
        this.value = value;
        this.key = key;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean isEmpty() {
        return (key == -1) && (value == null) && (rightChild == null) && (leftChild == null);
    }
}
