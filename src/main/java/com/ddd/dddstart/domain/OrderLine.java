package com.ddd.dddstart.domain;

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
