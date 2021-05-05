package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Money;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Money money)
    {
        if (money == null)
        {
            return null;
        }
        else
        {
            return money.getValue();
        }
    }

    @Override
    public Money convertToEntityAttribute(Integer dbData)
    {
        if (dbData == null) return null;
        else return new Money(dbData);
    }
}
