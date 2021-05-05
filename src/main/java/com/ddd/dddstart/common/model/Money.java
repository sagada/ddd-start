package com.ddd.dddstart.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Getter
@ToString
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
