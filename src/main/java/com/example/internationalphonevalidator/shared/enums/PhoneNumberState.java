package com.example.internationalphonevalidator.shared.enums;

public enum PhoneNumberState {

    VALID("valid"),
    NOT_VALID("not valid")
    ;

    private String value;

    PhoneNumberState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
