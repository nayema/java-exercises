package com.nayema.tests;

import com.nayema.EmptyListException;
import com.nayema.KeyNotFoundException;
import com.nayema.MyBinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MyBinarySearchTreeTest {

    @Test
    public void itInsertsValueToAnEmptyBST() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();

        bst.insert(1, "Cat");

        ArrayList<String> list = bst.getInorderStringList();
        assertThat(list, contains("Cat"));
    }

    @Test
    public void itInsertsSecondValueAsLeftChildBecauseKeyIsSmaller() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(2, "Cat");

        bst.insert(1, "Dog");

        ArrayList<String> list = bst.getInorderStringList();
        assertThat(list, contains("Dog", "Cat"));
    }

    @Test
    public void itInsertsSecondValueAsRightChildBecauseKeyIsLarger() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(2, "Cat");

        bst.insert(3, "Dog");

        ArrayList<String> list = bst.getInorderStringList();
        assertThat(list, contains("Cat", "Dog"));
    }

    @Test
    public void itInsertsThirdValueAsLeftOfLeftChild() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(3, "Cat");
        bst.insert(2, "Dog");

        bst.insert(1, "Rabbit");

        ArrayList<String> list = bst.getInorderStringList();
        assertThat(list, contains("Rabbit", "Dog", "Cat"));
    }

    @Test
    public void itInsertsThirdValueAsRightOfRightChild() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(1, "Cat");
        bst.insert(2, "Dog");

        bst.insert(3, "Rabbit");

        ArrayList<String> list = bst.getInorderStringList();
        assertThat(list, contains("Cat", "Dog", "Rabbit"));
    }

    @Test
    public void itThrowsExceptionIfListIsEmpty() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();

        assertThrows(EmptyListException.class, () -> bst.retrieve(1));
    }

    @Test
    public void itRetrievesValueAtRoot() throws EmptyListException {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(1, "Cat");

        String value = bst.retrieve(1);

        assertThat(value, is(equalTo("Cat")));
    }

    @Test
    public void itRetrievesValueFromLeftChildBecauseKeyIsSmaller() throws EmptyListException {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(2, "Cat");
        bst.insert(1, "Dog");

        String value = bst.retrieve(1);

        assertThat(value, is(equalTo("Dog")));
    }

    @Test
    public void itRetrievesValueFromRightChildBecauseKeyIsLarger() throws EmptyListException {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(1, "Cat");
        bst.insert(2, "Dog");

        String value = bst.retrieve(2);

        assertThat(value, is(equalTo("Dog")));
    }

    @Test
    public void itRetrievesValueFromLeftOfLeftChild() throws EmptyListException {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(3, "Rabbit");
        bst.insert(2, "Cat");
        bst.insert(1, "Dog");

        String value = bst.retrieve(1);

        assertThat(value, is(equalTo("Dog")));
    }

    @Test
    public void itRetrievesValueFromRightOfRightChild() throws EmptyListException {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(1, "Cat");
        bst.insert(2, "Dog");
        bst.insert(3, "Rabbit");

        String value = bst.retrieve(3);

        assertThat(value, is(equalTo("Rabbit")));
    }

    @Test
    public void itReturnsTrueIfGivenLeafNode() throws KeyNotFoundException {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(1, "Cat");
        bst.insert(2, "Dog");

        boolean isLeafNode = bst.isLeaf(2);

        assertThat(isLeafNode, is(equalTo(true)));
    }

    @Test
    public void itReturnsFalseIfGivenParentNode() throws KeyNotFoundException {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(3, "Cat");
        bst.insert(2, "Dog");
        bst.insert(4, "Rabbit");

        boolean isLeafNode = bst.isLeaf(3);

        assertThat(isLeafNode, is(equalTo(false)));
    }

    @Test
    public void itThrowsKeyNotFoundExceptionIfKeyDoesNotExistInTree() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();
        bst.insert(1, "not going to look for this");

        assertThrows(KeyNotFoundException.class, () -> bst.isLeaf(555));
    }
}
