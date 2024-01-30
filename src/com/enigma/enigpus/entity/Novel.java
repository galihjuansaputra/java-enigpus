package com.enigma.enigpus.entity;

import java.io.Serial;
import java.io.Serializable;

public class Novel extends Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    String code;
    String title;
    String publisher;
    Integer releaseYear;
    String writer;

    public Novel(String code, String title, String publisher, Integer releaseYear, String writer) {
        this.code = code;
        this.title = title;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.writer = writer;
    }

    public Novel(){

    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
