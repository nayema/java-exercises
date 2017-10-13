package com.nayema;

import java.util.ArrayList;

public class MyBinarySearchTree<E> {
    MyBinarySearchTreeNode<E> root;

    public ArrayList<E> getInorderStringList() {
        return getInorderStringList(root);
    }

    public void insert(int key, E value) {
        MyBinarySearchTreeNode<E> newNode = new MyBinarySearchTreeNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            insert(newNode, root);
        }
    }

    public E retrieve(int key) throws EmptyListException {
        if (root == null) {
            throw new EmptyListException("Tree is Empty");
        } else {
            return retrieve(root, key);
        }
    }

    public boolean isLeaf(int key) {
        return isLeaf(root, key);
    }

    private ArrayList<E> getInorderStringList(MyBinarySearchTreeNode<E> node) {
        ArrayList<E> list = new ArrayList<>();
        if (node != null) {
            list.addAll(getInorderStringList(node.leftChild));
            list.add(node.value);
            list.addAll(getInorderStringList(node.rightChild));
        }
        return list;
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

    private E retrieve(MyBinarySearchTreeNode node, int key) {
        if (key == node.key) {
            return (E) node.value;
        } else if (key < node.key) {
            return retrieve(node.leftChild, key);
        } else if (key > node.key) {
            return retrieve(node.rightChild, key);
        }
        return null;
    }

    private boolean isLeaf(MyBinarySearchTreeNode node, int key) {
        MyBinarySearchTreeNode currentNode = retrieveNode(node, key);
        return (!currentNode.hasLeftChild()) && (!currentNode.hasLeftChild());
    }

    private MyBinarySearchTreeNode retrieveNode(MyBinarySearchTreeNode node, int key) {
        if (key == node.key) {
            return node;
        } else if (key < node.key) {
            return retrieveNode(node.leftChild, key);
        } else if (key > node.key) {
            return retrieveNode(node.rightChild, key);
        }
        return null;
    }
}
