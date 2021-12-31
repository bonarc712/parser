package com.monsieurmahjong.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class XMLParserTest
{
    @Test
    public void xmlfiles_ignoreWhitespaces()
    {
        XMLParser parser = new XMLParser(null);
        boolean ignoreWhitespaces = parser.ignoreWhitespaces();
        assertTrue(ignoreWhitespaces, "XML ignores whitespaces");
    }

//    @Test
//    public void xmlDocument_withRootRootAsRoot_shouldHaveRootRoot()
//    {
//        File randomXMLDocument = new File("resources/randomXML1.xml");
//        XMLParser parser = new XMLParser(randomXMLDocument);
//
//        Tree parsedTree = parser.parse();
//        Node root = parsedTree.getRoot();
//
//        assertEquals("root", root.getValue(), "Document with root named root should have a root named root");
//    }

//    @Test
//    public void xmlDocument_withNodePrevent_shouldHaveNodePreventPresent()
//    {
//        XMLParser parser = new XMLParser();
//
//        Tree parsedTree = parser.parse();
//        boolean hasNode = parsedTree.hasNodeWithValue("prevent");
//
//        assertTrue(hasNode, "Document with a node named prevent should have it present");
//    }
}
