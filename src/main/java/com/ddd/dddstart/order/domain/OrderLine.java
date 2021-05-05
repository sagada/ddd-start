package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.product.ProductId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@Getter
public class OrderLine {

    @Embedded
    private ProductId productId;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    private Integer amounts;

    public OrderLine(ProductId productId, Integer price, int quantity, Integer amounts) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = amounts;
    }
}
