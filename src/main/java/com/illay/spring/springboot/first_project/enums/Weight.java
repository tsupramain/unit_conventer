package com.illay.spring.springboot.first_project.enums;

public enum Weight {
    KG(1, "KG"),
    LB(0.453592, "LB"),
    GR(0.001, "GR"),
    T(1000.0, "T");

    private final double multiplier;
    private String fullName;

    Weight(double multiplier, String fullName) {
        this.multiplier = multiplier;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
