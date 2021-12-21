package com.monsieurmahjong.parser.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TreeTest
{
    @Test
    public void tree_withRootRootAsRoot_shouldHaveRootRoot()
    {
        Node root = new Node("root");
        Tree tree = new Tree();
        tree.addElementAtRoot(root);

        List<Node> rootNodeList = tree.getRootList();

        assertTrue(rootNodeList.contains(root), "Root root should be a root");
    }

    @Test
    public void tree_withManyRoots_shouldSeeAllOfThem()
    {
        Node root = new Node("root");
        Node root2 = new Node("root2");
        Node root3 = new Node("root3");
        Tree tree = new Tree();
        tree.addElementAtRoot(root);
        tree.addElementAtRoot(root2);
        tree.addElementAtRoot(root3);

        List<Node> rootNodeList = tree.getRootList();

        assertTrue(rootNodeList.contains(root2), "Root of the tree should have root2 element");
    }

    @Test
    public void tree_withANodeNamedLeaf_shouldFindNodeLeaf()
    {
        Node root = new Node("root");
        Node leaf = new Node("leaf");
        root.addChild(leaf);
        Tree tree = new Tree();
        tree.addElementAtRoot(root);

        boolean treeHasNode = tree.hasNodeWithValue("leaf");

        assertTrue(treeHasNode, "Tree should have the node leaf");
    }
}
