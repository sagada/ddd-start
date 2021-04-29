package com.ddd.dddstart.domain;

import lombok.Getter;

@Getter
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}
