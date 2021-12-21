package com.monsieurmahjong.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

public class GenericTests
{
    @Test
    public void xmlDocument_calledRandomXML1XML_canBeFound()
    {
        File randomXMLDocument = new File("resources/randomXML1.xml");

        assertTrue(randomXMLDocument.exists());
    }

}
