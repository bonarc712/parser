package com.monsieurmahjong.parser;

import java.io.File;

import com.monsieurmahjong.parser.model.Node;
import com.monsieurmahjong.parser.model.Tree;

public class XMLParser implements Parser
{
    private File file;
    private Tree tree;

    public XMLParser(File file)
    {
        this.file = file;
        tree = new Tree();
    }

    public Tree parse()
    {
        FileReader.getLinesFromFile(file).forEach(this::interpretLine);
        return tree;
    }

    public void interpretLine(String line)
    {
        if (line.contains("<"))
        {
            String element = line.substring(line.indexOf("<") + 1, line.indexOf(">"));
            tree.addElementAtRoot(new Node(element));
        }
    }

    public boolean ignoreWhitespaces()
    {
        return true;
    }
}
