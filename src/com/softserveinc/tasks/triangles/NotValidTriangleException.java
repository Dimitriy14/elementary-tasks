package com.softserveinc.tasks.triangles;

public class NotValidTriangleException extends RuntimeException{
    public NotValidTriangleException(String msg) {
        super("Triangle is invalid " + msg);
    }
}
