package com.aldo.experiments.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Bfs implements TreeRunner {
    Queue<TreeNode> q = new LinkedList();

    @Override
    public <T> void run(TreeNode<T> head, Consumer<T> action) {
        addNode(head);

        while (!q.isEmpty()) {
            TreeNode<T> node = q.poll();
            action.accept(node.getValue());

            addNode(node.getLeft());
            addNode(node.getRight());
        }
    }

    private <T> void addNode(TreeNode<T> node) {
        if (node != null) {
            q.add(node);
        }
    }
}
