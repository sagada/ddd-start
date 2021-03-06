package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Money;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class OrderLines {
    private List<OrderLine> lines;

    public void changeOrderLines(List<OrderLine> newLines)
    {
        this.lines = newLines;
    }
}
