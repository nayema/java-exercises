package com.nayema;

import java.util.ArrayList;

public class MyBinarySearchTree<E> {
    MyBinarySearchTreeNode<E> root;

    public void insert(int key, E value) {
        if (root == null) {
            root = new MyBinarySearchTreeNode<>(key, value);
        }
        if (key < root.key) {
            if (root.leftChild == null) {
                root.leftChild = new MyBinarySearchTreeNode<>(key, value);
            }
        } else if (key > root.key) {
            if (root.rightChild == null) {
                root.rightChild = new MyBinarySearchTreeNode<>(key, value);
            }
        }
    }

    public ArrayList<E> getInorderStringList() {
        return getInorder(root);
    }

    private ArrayList<E> getInorder(MyBinarySearchTreeNode<E> node) {
        ArrayList<E> list = new ArrayList<>();
        if (node != null) {
            list.addAll(getInorder(node.leftChild));
            list.add(node.value);
            list.addAll(getInorder(node.rightChild));
        }
        return list;
    }
}
