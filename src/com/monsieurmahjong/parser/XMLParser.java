package com.monsieurmahjong.parser;

import java.io.File;

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

        FileReader.getLinesFromFile(file).forEach(this::interpretLine);

        return tree;
    }

    public void interpretLine(String line)
    {
        // TODO implement this
    }
}
