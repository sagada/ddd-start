package com.ddd.dddstart.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;

}
