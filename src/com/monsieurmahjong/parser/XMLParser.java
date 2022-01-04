package com.monsieurmahjong.parser;

import java.io.File;

import com.monsieurmahjong.parser.exception.InvalidSyntaxException;
import com.monsieurmahjong.parser.model.Node;
import com.monsieurmahjong.parser.model.Tree;

public class XMLParser implements Parser
{
    private File file;
    private Tree tree;

    private Node currentInterpretedNode;

    public XMLParser(File file)
    {
        this.file = file;
        tree = new Tree();
    }

    @Override
    public Tree parse()
    {
        FileReader.getLinesFromFile(file).forEach(this::interpretLine);
        return tree;
    }

    protected void interpretLine(String line)
    {
        if (ignoreWhitespaces())
        {
            line = line.trim();
        }

        if (line == null || line.isEmpty())
        {
            return;
        }

        char firstCharacter = line.charAt(0);
        if (isSpecialCharacter(firstCharacter))
        {
            if (line.startsWith("</"))
            {
                line = readNodeEnd(line);
            }
            else if (line.startsWith("<"))
            {
                line = readNode(line);
            }
        }
        else
        {
            line = readLeaf(line);
        }

        interpretLine(line);
    }

    private String readLeaf(String line)
    {
        int subStringEnd = line.length();
        for (int i = 0; i < line.length(); i++)
        {
            if (isSpecialCharacter(line.charAt(i)))
            {
                subStringEnd = i;
                break;
            }
        }

        String leafElement = line.substring(0, subStringEnd);
        Node leafNode = new Node(leafElement);
        addCurrentNodeToTheTree(leafNode);

        return line.substring(subStringEnd);
    }

    private String readNodeEnd(String line)
    {
        String element = line.substring(line.indexOf("<") + 2, line.indexOf(">"));
        if (!element.equals(currentInterpretedNode.getValue()))
        {
            throw new InvalidSyntaxException();
        }
        currentInterpretedNode = currentInterpretedNode.getParent();
        return line.substring(line.indexOf(">") + 1);
    }

    private String readNode(String line)
    {
        boolean nodeWithClosingBracket = line.contains("/>");
        int lastIndexOfSubstring = nodeWithClosingBracket ? line.indexOf("/") : line.indexOf(">");
        String element = line.substring(line.indexOf("<") + 1, lastIndexOfSubstring);
        element = element.trim();
        Node currentNode = new Node(element);
        addCurrentNodeToTheTree(currentNode);
        if (!nodeWithClosingBracket)
        {
            currentInterpretedNode = currentNode;
        }
        return line.substring(line.indexOf(">") + 1);
    }

    private boolean isSpecialCharacter(char character)
    {
        return character == '<';
    }

    private void addCurrentNodeToTheTree(Node currentNode)
    {
        if (currentInterpretedNode == null)
        {
            tree.addElementAtRoot(currentNode);
        }
        else
        {
            currentInterpretedNode.addChild(currentNode);
        }
    }

    @Override
    public boolean ignoreWhitespaces()
    {
        return true;
    }
}
