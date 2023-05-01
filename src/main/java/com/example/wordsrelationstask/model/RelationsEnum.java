package com.example.wordsrelationstask.model;

public enum RelationsEnum {
    SYNONYM ("synonym"),
    ANTONYM ("antonym"),
    RELATED ("related");

    private String value;

    RelationsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
