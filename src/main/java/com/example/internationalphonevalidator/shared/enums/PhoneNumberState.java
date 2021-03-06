package com.example.internationalphonevalidator.shared.enums;

public enum PhoneNumberState {

    VALID("valid"),
    INVALID("not valid")
    ;

    private String value;

    PhoneNumberState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
