package com.ddd.dddstart.domain;

import java.util.List;

public interface RuleDiscounter {
    Money applyRules(Customer customer, List<OrderLine> orderLineList);
}
