package com.monsieurmahjong.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FileReaderTest
{
    @Test
    public void xmlFile_withSixLines_ShouldIndeedHaveSixLines()
    {
        List<String> resultLines = FileReader.getLinesFromFile(new File("resources/randomXML1.xml"));

        assertEquals(6, resultLines.size(), "randomXML1.xml should have six lines");
    }

    @Test
    public void xmlFile_withThirtySixLines_ShouldIndeedHaveThirtySixLines()
    {
        List<String> resultLines = FileReader.getLinesFromFile(new File("resources/randomXML2.xml"));

        assertEquals(36, resultLines.size(), "randomXML2.xml should have thirty-six lines");
    }

    @Test
    public void xmlFile_ThatDoesntExist_ShouldHaveZeroLines()
    {
        List<String> resultLines = FileReader.getLinesFromFile(new File("resources/euojaghgaeouihetugphaetgi9ah.xml"));

        assertTrue(resultLines.isEmpty(), "non-existing xml should have zero lines");
    }
}
