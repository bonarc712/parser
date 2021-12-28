package com.monsieurmahjong.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader
{
    public static List<String> getLinesFromFile(File file)
    {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                lines.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found : " + e);
            return new ArrayList<>();
        }
        return lines;
    }
}
