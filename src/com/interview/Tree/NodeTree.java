package com.interview.Tree;

/**
 * Created by dongmc on 2018/5/22.
 */
public class NodeTree {

    private NodeTree left;
    private NodeTree right;
    private final char value;

    public NodeTree(char value) {
        this.value = value;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRgiht() {
        return right;
    }

    public void setRgiht(NodeTree right) {
        this.right = right;
    }

    public char getValue() {
        return value;
    }
}
