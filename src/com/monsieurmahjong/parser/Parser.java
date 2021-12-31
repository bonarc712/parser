package com.monsieurmahjong.parser;

import com.monsieurmahjong.parser.model.Tree;

public interface Parser
{
    public Tree parse();

    public boolean ignoreWhitespaces();
}
