package com.interview.Tree;

/**
 * Created by dongmc on 2018/5/22.
 */
public class TreeCreator {

    public static NodeTree createSimpleTree() {
        NodeTree treeA = new NodeTree('A');
        NodeTree treeB = new NodeTree('B');
        NodeTree treeC = new NodeTree('C');
        NodeTree treeD = new NodeTree('D');
        NodeTree treeE = new NodeTree('E');
        NodeTree treeF = new NodeTree('F');
        NodeTree treeG = new NodeTree('G');

        treeA.setLeft(treeB);
        treeA.setRgiht(treeC);

        treeB.setLeft(treeD);
        treeB.setRgiht(treeE);

        treeC.setRgiht(treeF);

        treeE.setLeft(treeG);

        return treeA;
    }
}
