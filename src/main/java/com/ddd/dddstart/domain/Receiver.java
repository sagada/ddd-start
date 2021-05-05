package com.ddd.dddstart.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
