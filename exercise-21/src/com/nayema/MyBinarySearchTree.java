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
            } //else {
//                insert(key, value);
//            }
//        } else if (key > currentNode.key) {
//            if (currentNode.rightChild == null) {
//                currentNode.rightChild = new MyBinarySearchTreeNode<>(key, value);
//            } else {
//                insert(key, value);
//            }
        }
    }

    public ArrayList<E> getInorderStringList() {
        return getInorder(root);
//        ArrayList<E> list = new ArrayList<>();
//        MyBinarySearchTreeNode<E> currentNode = root;
//        if (currentNode != null) {
//            getInorder(currentNode.leftChild);
//            list.add(currentNode.value);
//            getInorder(currentNode.rightChild);
//        }
//        return list;
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
