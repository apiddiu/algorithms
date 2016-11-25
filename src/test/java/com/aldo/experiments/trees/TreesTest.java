package com.aldo.experiments.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class TreesTest {

    private List<Integer> expectedDfsResult = Arrays.asList(0, 1, 3, 6, 7, 9, 2, 4, 5, 8);
    private List<Integer> expectedBfsResult = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    private TreeNode<Integer> tree;
    private Accumulator accumulator;

    @Before
    public void setUp() throws Exception {
        tree = buildTree();
        accumulator = new Accumulator<>();
    }

    @Test
    public void dfsTest() {
        new Dfs().run(tree, accumulator);
        checkResults(expectedDfsResult);
    }

    @Test
    public void bfsTest() {
        new Bfs().run(tree, accumulator);
        checkResults(expectedBfsResult);
    }

    private<T> void checkResults(List<T> expectedResult){
        List<T> result = accumulator.getElements();
        out.println(result);
        assertEquals(expectedResult, result);
    }

    private TreeNode<Integer> buildTree() {
        /**
         *          0
         *         / \
         *        1   2
         *       /   / \
         *      3   4   5
         *     / \       \
         *    6   7       8
         *       /
         *      9
         */

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n0.setLeft(n1);
        n0.setRight(n2);
        n1.setLeft(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n5.setRight(n8);
        n7.setLeft(n9);

        return n0;
    }

    class Accumulator<T> implements Consumer<T> {
        List<T> elements = new LinkedList<T>();

        @Override
        public void accept(T t) {
            elements.add(t);
        }

        public List<T> getElements() {
            return elements;
        }
    }
}
