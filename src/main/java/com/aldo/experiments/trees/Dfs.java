package com.aldo.experiments.trees;

import java.util.function.Consumer;

public class Dfs implements TreeRunner {
    @Override
    public<T> void run(TreeNode<T> head, Consumer<T> action){
        if(head!=null){
            action.accept(head.getValue());
            run(head.getLeft(), action);
            run(head.getRight(), action);
        }
    }
}
