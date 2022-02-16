package com.monsieurmahjong.parser.model;

import java.util.*;

public class Node
{
    private String value;

    private List<Attribute> attributes;
    private List<Node> childNodes;

    private Node parent;

    public Node()
    {
        childNodes = new ArrayList<>();
        attributes = new ArrayList<>();
    }

    public Node(String value)
    {
        this();
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public void addChild(Node child)
    {
        childNodes.add(child);
        child.setParent(this);
    }

    public List<Node> getChildNodes()
    {
        return childNodes;
    }

    public boolean hasChildNodes()
    {
        return !childNodes.isEmpty();
    }

    public Node getParent()
    {
        return parent;
    }

    private void setParent(Node parent)
    {
        this.parent = parent;
    }

    public boolean isRoot()
    {
        return parent == null;
    }

    public void addAttribute(Attribute attribute)
    {
        attributes.add(attribute);
    }

    public List<Attribute> getAttributes()
    {
        return attributes;
    }

    @Override
    public String toString()
    {
        StringBuilder nodeString = new StringBuilder();
        nodeString.append(value);
        if (parent != null)
        {
            nodeString.append(" (parent: " + parent.getValue() + ")");
        }
        return nodeString.toString();
    }
}
