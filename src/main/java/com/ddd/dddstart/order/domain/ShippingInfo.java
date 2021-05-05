package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Address;
import com.ddd.dddstart.domain.Receiver;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Embeddable
public class ShippingInfo {
    @Embedded
    private Receiver receiver;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zipcode"))
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;

}
