package com.nayema;

import java.util.ArrayList;

public class MyBinarySearchTree<E> {
    MyBinarySearchTreeNode<E> root;

    public ArrayList<E> getInorderStringList() {
        return getInorderStringListRecursively(root);
    }

    public void insert(int key, E value) {
        MyBinarySearchTreeNode<E> newNode = new MyBinarySearchTreeNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            insertRecursively(newNode, root);
        }
    }

    public E retrieve(int key) throws EmptyListException {
        if (root == null) {
            throw new EmptyListException("Tree is Empty");
        } else {
            return retrieveNodeRecursively(root, key).value;
        }
    }

    public boolean isLeaf(int key) {
        MyBinarySearchTreeNode<E> currentNode = retrieveNodeRecursively(root, key);
        return (!currentNode.hasLeftChild()) && (!currentNode.hasRightChild());
    }

    private ArrayList<E> getInorderStringListRecursively(MyBinarySearchTreeNode<E> node) {
        ArrayList<E> list = new ArrayList<>();
        if (node != null) {
            list.addAll(getInorderStringListRecursively(node.leftChild));
            list.add(node.value);
            list.addAll(getInorderStringListRecursively(node.rightChild));
        }
        return list;
    }

    private void insertRecursively(MyBinarySearchTreeNode<E> newNode, MyBinarySearchTreeNode<E> subTreeNode) {
        if (newNode.key < subTreeNode.key) {
            if (subTreeNode.leftChild == null) {
                subTreeNode.leftChild = newNode;
            } else {
                insertRecursively(newNode, subTreeNode.leftChild);
            }
        } else if (newNode.key > subTreeNode.key) {
            if (subTreeNode.rightChild == null) {
                subTreeNode.rightChild = newNode;
            } else {
                insertRecursively(newNode, subTreeNode.rightChild);
            }
        }
    }

    private MyBinarySearchTreeNode<E> retrieveNodeRecursively(MyBinarySearchTreeNode<E> node, int key) {
        if (key == node.key) {
            return node;
        } else if (key < node.key) {
            return retrieveNodeRecursively(node.leftChild, key);
        } else if (key > node.key) {
            return retrieveNodeRecursively(node.rightChild, key);
        }
        return null;
    }

}
