package com.aldo.experiments.trees;

import java.util.function.Consumer;

public interface TreeRunner {

    <T> void run(TreeNode<T> head, Consumer<T> action);
}
