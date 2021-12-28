package com.monsieurmahjong.parser;

import java.io.File;

public class SomeClass
{
    public static void main(String[] args)
    {
        XMLParser parser = new XMLParser(new File("resources/randomXML1.xml"));
        parser.parse();
    }
}
