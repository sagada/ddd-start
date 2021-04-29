package com.ddd.dddstart.domain;

import lombok.Getter;

@Getter
public class Address {
    private String address;
    private String zipcode;

    public Address(String address, String zipcode) {
        this.address = address;
        this.zipcode = zipcode;
    }
}