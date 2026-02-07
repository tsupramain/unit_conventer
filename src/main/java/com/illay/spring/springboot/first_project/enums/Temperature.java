package com.illay.spring.springboot.first_project.enums;

public enum Temperature {
    C("C"),
    F("F"),
    K("K");

    private final String fullName;

    Temperature(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}