package com.monsieurmahjong.parser.exception;

public class InvalidSyntaxException extends RuntimeException
{
    private static final long serialVersionUID = 7902862185920671208L;

    public InvalidSyntaxException()
    {
        super();
    }

    public InvalidSyntaxException(String message)
    {
        super(message);
    }
}
