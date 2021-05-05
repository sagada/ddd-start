package com.ddd.dddstart.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {
    @Column(name = "email")
    private String email;

    public Email(String email) {
        this.email = email;
    }
}
