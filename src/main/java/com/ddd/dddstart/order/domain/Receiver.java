package com.ddd.dddstart.order.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * λΆλ³ νμ
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
