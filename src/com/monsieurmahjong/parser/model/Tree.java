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
                .flatMap(node -> getFlatListOfNodesUsingParent(node).stream()) //
                .collect(Collectors.toList());
    }

    public List<Node> getFlatListOfNodesUsingParent(Node node)
    {
        List<Node> toReturn = new ArrayList<>();
        toReturn.add(node);
        for (Node childNode : node.getChildNodes())
        {
            if (childNode.hasChildNodes())
            {
                toReturn.addAll(getFlatListOfNodesUsingParent(childNode));
            }
            else
            {
                toReturn.add(childNode);
            }
        }
        return toReturn;
    }

    public boolean hasNodeWithValue(String value)
    {
        return getFlatListOfNodes().stream().filter(node -> value.equals(node.getValue())).findAny().isPresent();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        getFlatListOfNodes().forEach(node -> builder.append(node + "\n"));
        return builder.toString();
    }
}
