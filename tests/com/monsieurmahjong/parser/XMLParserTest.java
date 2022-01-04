package com.monsieurmahjong.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.monsieurmahjong.parser.exception.InvalidSyntaxException;
import com.monsieurmahjong.parser.model.Node;
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

    @Test
    public void xmlNodeRegular_withParentPrevent_shouldHavePreventAsParent()
    {
        File randomXMLDocument = new File("resources/randomXML1.xml");
        Parser parser = new XMLParser(randomXMLDocument);

        Tree parsedTree = parser.parse();

        Node regularNode = parsedTree.getNodesWithValue("regular").get(0);
        Node regularNodeParent = regularNode.getParent();
        assertEquals("prevent", regularNodeParent.getValue(), "Node regular should have parent prevent");
    }

    @Test
    public void xmlFile_withFiftySevenNodes_shouldHaveThatMuch()
    {
        File randomXMLDocument = new File("resources/randomXML2.xml");
        Parser parser = new XMLParser(randomXMLDocument);

        Tree parsedTree = parser.parse();

        assertEquals(57, parsedTree.getFlatListOfNodes().size(), "RandomXML2 tree should have 57 elements");
    }

    @Test
    public void closingBracket_inXMLFile_shouldNotIncludeTheDash()
    {
        File xmlWithClosingBracket = new File("resources/xmlWithClosingBracket.xml");
        Parser parser = new XMLParser(xmlWithClosingBracket);

        Tree tree = parser.parse();

        assertFalse(tree.getNodesWithValue("prevent").isEmpty(), "A node named prevent should be present");
    }

    @Test
    public void xmlFile_withBadSyntax_ShouldThrowException()
    {
        File badSyntaxFile = new File("resources/badSyntaxXM-L.txt");
        Parser parser = new XMLParser(badSyntaxFile);

        assertThrows(InvalidSyntaxException.class, () -> parser.parse());
    }
}
