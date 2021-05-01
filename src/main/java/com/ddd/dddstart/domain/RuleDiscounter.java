package com.ddd.dddstart.domain;

import com.ddd.dddstart.common.model.Money;
import com.ddd.dddstart.order.domain.OrderLine;

import java.util.List;

public interface RuleDiscounter {
    Money applyRules(Customer customer, List<OrderLine> orderLineList);
}
