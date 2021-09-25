package com.tinkoff.edu.domain.enumeration;

/**
 * The Language enumeration.
 */
public enum Language {
    RU("RUSSIAN"),
    EN("ENGLISH"),
    ES("SPANISH");

    private final String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
