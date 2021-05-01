package com.ddd.dddstart.domain;

import com.ddd.dddstart.common.model.Money;
import com.ddd.dddstart.order.domain.OrderLine;

import java.util.List;

public class CalculateDiscountService {
    private RuleDiscounter ruleDiscounter;

    public CalculateDiscountService(RuleDiscounter ruleDiscounter)
    {
        this.ruleDiscounter = ruleDiscounter;
    }

    public Money calculateDiscount(List<OrderLine> orderLineList, String customerId)
    {

    }
}
