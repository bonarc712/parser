package com.monsieurmahjong.parser.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tree
{
    private List<Node> rootList = new ArrayList<>();

    public List<Node> getRootList()
    {
        return rootList;
    }

    public void addElementAtRoot(Node node)
    {
        rootList.add(node);
    }

    public List<Node> getFlatListOfNodes()
    {
        return rootList.stream() //
                .flatMap(node -> getFlatListOfNodesUsingRoot(node).stream()) //
                .collect(Collectors.toList());
    }

    public List<Node> getFlatListOfNodesUsingRoot(Node root)
    {
        List<Node> toReturn = new ArrayList<>();
        for (Node node : root.getChildNodes())
        {
            toReturn.add(node);
            if (node.hasChildNodes())
            {
                toReturn.addAll(getFlatListOfNodesUsingRoot(node));
            }
        }
        return toReturn;
    }

    public boolean hasNodeWithValue(String value)
    {
        return getFlatListOfNodes().stream().filter(node -> node.getValue() == value).findAny().isPresent();
    }
}
