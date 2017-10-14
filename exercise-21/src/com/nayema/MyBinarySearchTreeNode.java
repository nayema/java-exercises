package com.nayema;

public class MyBinarySearchTreeNode<E> {
    public E value;
    public int key = 0;
    public MyBinarySearchTreeNode<E> leftChild;
    public MyBinarySearchTreeNode<E> rightChild;

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
}
