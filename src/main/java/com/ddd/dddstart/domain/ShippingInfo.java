package com.ddd.dddstart.domain;

import com.ddd.dddstart.common.model.Address;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}
