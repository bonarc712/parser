package com.monsieurmahjong.parser.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class NodeTest
{
    @Test
    public void aNode_canBeAdded_ToAnotherNode()
    {
        Node parent = new Node("test");
        Node child = new Node("test2");
        parent.addChild(child);

        List<Node> childNodes = parent.getChildNodes();

        assertTrue(childNodes.contains(child), "Parent should contain the child");
    }

    @Test
    public void aNode_canHave_attributes()
    {
        Node node = new Node();
        node.addAttribute("test");

        List<String> attributes = node.getAttributes();

        assertTrue(attributes.contains("test"), "Attribute should be created and added");
    }
}
