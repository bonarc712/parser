package com.monsieurmahjong.parser.model;

public class Attribute
{
    private String key;
    private String value;

    public Attribute(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "Attribute: " + key + " with value " + value;
    }
}
