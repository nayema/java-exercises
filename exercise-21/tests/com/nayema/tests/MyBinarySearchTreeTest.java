package com.nayema.tests;

import com.nayema.MyBinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyBinarySearchTreeTest {

    @Test
    public void itInsertsValueToAnEmptyBST() {
        MyBinarySearchTree<String> bst = new MyBinarySearchTree<>();

        bst.insert(1, "Cat");

        ArrayList<String> list = bst.getInorderStringList();
        assertThat(list, contains("Cat"));
    }
}
