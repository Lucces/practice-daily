package com.interview.Tree;

/**
 * Created by dongmc on 2018/5/22.
 */
public class TreeTraversal {

    public void prevOrder(NodeTree tree) {

        if (tree == null) {
            return;
        }
        System.out.print(tree.getValue());
        prevOrder(tree.getLeft());
        prevOrder(tree.getRgiht());
    }

    public void inOrder(NodeTree tree) {

        if (tree == null) {
            return;
        }

        inOrder(tree.getLeft());
        System.out.print(tree.getValue());
        inOrder(tree.getRgiht());
    }

    public void postOrder(NodeTree tree) {

        if (tree == null) {
            return;
        }

        postOrder(tree.getLeft());
        postOrder(tree.getRgiht());
        System.out.print(tree.getValue());
    }


    public static void main(String[] args) {

        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.prevOrder(TreeCreator.createSimpleTree());
        System.out.println();
        treeTraversal.inOrder(TreeCreator.createSimpleTree());
        System.out.println();
        treeTraversal.postOrder(TreeCreator.createSimpleTree());

    }
}
