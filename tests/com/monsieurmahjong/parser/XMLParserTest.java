package com.monsieurmahjong.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.monsieurmahjong.parser.model.Tree;

public class XMLParserTest
{
    @Test
    public void xmlfiles_ignoreWhitespaces()
    {
        XMLParser parser = new XMLParser(null);
        boolean ignoreWhitespaces = parser.ignoreWhitespaces();
        assertTrue(ignoreWhitespaces, "XML ignores whitespaces");
    }

    @Test
    public void xmlDocument_withRootRootAsRoot_shouldHaveRootRoot()
    {
        File randomXMLDocument = new File("resources/randomXML1.xml");
        Parser parser = new XMLParser(randomXMLDocument);

        Tree parsedTree = parser.parse();
        boolean hasRoot = parsedTree.getRootList().stream().anyMatch(node -> "root".equals(node.getValue()));

        assertTrue(hasRoot, "Document with root named root should have a root named root");
    }

    @Test
    public void xmlDocument_withNodePrevent_shouldHaveNodePreventPresent()
    {
        File randomXMLDocument = new File("resources/randomXML1.xml");
        Parser parser = new XMLParser(randomXMLDocument);

        Tree parsedTree = parser.parse();
        boolean hasNode = parsedTree.hasNodeWithValue("prevent");

        assertTrue(hasNode, "Document with a node named prevent should have it present");
    }

    @Test
    public void xmlDocument_withLeafColor_shouldHaveLeafColorPresent()
    {
        File randomXMLDocument = new File("resources/randomXML1.xml");
        Parser parser = new XMLParser(randomXMLDocument);

        Tree parsedTree = parser.parse();
        boolean hasNode = parsedTree.hasNodeWithValue("color");

        assertTrue(hasNode, "Document with a leaf named color should have it present");
    }
}
