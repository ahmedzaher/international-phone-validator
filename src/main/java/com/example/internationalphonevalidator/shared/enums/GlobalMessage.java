package com.example.internationalphonevalidator.shared.enums;

public enum GlobalMessage {
    UNKNOWN("Unknown");

    private String value;

    GlobalMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
