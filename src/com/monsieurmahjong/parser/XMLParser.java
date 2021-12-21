package com.monsieurmahjong.parser;

import java.io.File;

import com.monsieurmahjong.parser.model.Node;
import com.monsieurmahjong.parser.model.Tree;

public class XMLParser
{
    private File file;
    private Tree tree;

    public XMLParser(File file)
    {
        this.file = file;
    }

    public Tree parse()
    {
        tree = new Tree();

        // read file

        tree.addElementAtRoot(new Node());
        return tree;
    }
}
