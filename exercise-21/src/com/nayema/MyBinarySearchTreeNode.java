package com.nayema;

public class MyBinarySearchTreeNode<E> {
    public E value;
    public int key;
    public MyBinarySearchTreeNode<E> right;
    public MyBinarySearchTreeNode<E> left;

    public MyBinarySearchTreeNode(E value) {
        this.value = value;
    }
}
