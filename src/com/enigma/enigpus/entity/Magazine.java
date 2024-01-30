package com.enigma.enigpus.entity;

import java.io.Serial;
import java.io.Serializable;

public class Magazine extends Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    String code;
    String title;
    String releasePer;
    Integer releaseYear;

    public Magazine(String code, String title, String releasePer, Integer releaseYear) {
        this.code = code;
        this.title = title;
        this.releasePer = releasePer;
        this.releaseYear = releaseYear;
    }

    public Magazine(){

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

    public String getReleasePer() {
        return releasePer;
    }

    public void setReleasePer(String releasePer) {
        this.releasePer = releasePer;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
