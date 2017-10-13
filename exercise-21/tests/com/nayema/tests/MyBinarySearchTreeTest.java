package com.nayema.tests;

import com.nayema.EmptyListException;
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
}
