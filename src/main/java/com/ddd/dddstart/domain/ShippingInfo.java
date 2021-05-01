package com.ddd.dddstart.domain;

import com.ddd.dddstart.common.model.Address;
import lombok.Getter;

@Getter
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}
