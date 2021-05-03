package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.domain.Product;
import lombok.Getter;

@Getter
public class OrderLine {
    private Product product;
    private Integer price;
    private int quantity;
    private Integer amounts;

    public OrderLine(Product product, Integer price, int quantity, Integer amounts) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = amounts;
    }
}
