package com.nayema;

import java.util.ArrayList;

public class MyBinarySearchTree<E> {
    MyBinarySearchTreeNode<E> root;

    public void insert(int key, E value) {
        MyBinarySearchTreeNode<E> newNode = new MyBinarySearchTreeNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            insert(newNode, root);
        }
    }

    public ArrayList<E> getInorderStringList() {
        return getInorder(root);
    }

    private void insert(MyBinarySearchTreeNode<E> newNode, MyBinarySearchTreeNode<E> subTreeNode) {
        if (newNode.key < subTreeNode.key) {
            if (subTreeNode.leftChild == null) {
                subTreeNode.leftChild = newNode;
            } else {
                insert(newNode, subTreeNode.leftChild);
            }
        } else if (newNode.key > subTreeNode.key) {
            if (subTreeNode.rightChild == null) {
                subTreeNode.rightChild = newNode;
            } else {
                insert(newNode, subTreeNode.rightChild);
            }
        }
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
