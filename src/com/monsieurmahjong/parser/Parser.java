package com.monsieurmahjong.parser;

import com.monsieurmahjong.parser.model.Tree;

public interface Parser
{
    public Tree parse();

    /**
     * Ignores file whitespaces (leading spaces and tabs) but not value whitespaces
     * (eg. the string " root" will include the leading spaces)
     */
    public boolean ignoreWhitespaces();
}
