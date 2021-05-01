package com.ddd.dddstart.common.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public Money add(Money money){
        return new Money(this.value + money.getValue());
    }

    public Money multiply(int multiplier)
    {
        return new Money(value * multiplier);
    }
}
