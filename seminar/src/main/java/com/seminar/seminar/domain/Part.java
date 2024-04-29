package com.seminar.seminar.domain;

public enum Part {
    SERVER("SERVER"),
    WEB("WEB"),
    ANDROID("ANDROID"),
    IOS("IOS"),
    DESIGN("DESIGN"),
    PLAN("PLAN"),
    ;
    public String part;

    Part(String part) {
        this.part = part;
    }
}
