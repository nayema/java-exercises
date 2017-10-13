package com.nayema;

import java.util.ArrayList;

public class MyBinarySearchTree<E> {
    MyBinarySearchTreeNode<E> root;

    public void insert(int key, E value) {
        if (root == null) {
            root = new MyBinarySearchTreeNode<>(key, value);
        }
//        if (key < currentNode.key) {
//            if (currentNode.leftChild == null) {
//                currentNode.leftChild = new MyBinarySearchTreeNode<>(key, value);
//            } else {
//                insert(key, value);
//            }
//        } else if (key > currentNode.key) {
//            if (currentNode.rightChild == null) {
//                currentNode.rightChild = new MyBinarySearchTreeNode<>(key, value);
//            } else {
//                insert(key, value);
//            }
//        }
    }

    public ArrayList<E> getInorderStringList() {
        ArrayList<E> list = new ArrayList<>();
        list.add(root.value);
        return list;
//        ArrayList<E> list = new ArrayList<>();
//        MyBinarySearchTreeNode<E> currentNode = root;
//        if (currentNode != null) {
//            getInorder(currentNode.leftChild);
//            list.add(currentNode.value);
//            getInorder(currentNode.rightChild);
//        }
//        return list;
    }

    private void getInorder(MyBinarySearchTreeNode<E> root) {
        if (root != null) {
            getInorder(root.leftChild);
            System.out.println(root.key + "," + root.value);
            getInorder(root.rightChild);
        }
    }
}
