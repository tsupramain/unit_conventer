package com.illay.spring.springboot.first_project.enums;

public enum Lenght {
    CM(0.01, "CM"),
    M(1.0, "M"),
    KM(1000.0, "KM"),
    INCH(0.0254, "INCH"),
    FOOT(0.3048, "FOOT");

    private final double multiplier;
    private final String fullName;

    Lenght(double multiplier, String fullName) {
        this.multiplier = multiplier;
        this.fullName = fullName;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getFullName() {
        return fullName;
    }
}

