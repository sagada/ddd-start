package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Money;
import com.ddd.dddstart.domain.Product;
import lombok.Getter;

@Getter
public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity, Money amounts) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = amounts;
    }
}
