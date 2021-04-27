package com.ddd.dddstart.domain;

import java.util.List;

public class Order {

    private List<OrderLine> orderLineList;
    private Money totalAmounts;
    private ShippingInfo shippingInfo;
    private OrderState orderState;

    public Order(List<OrderLine> orderLineList, ShippingInfo shippingInfo)
    {
        setShippingInfo(shippingInfo);
        setOrderLines(orderLineList);
    }

    private void setShippingInfo(ShippingInfo shippingInfo)
    {
        if (shippingInfo == null)
            throw new IllegalArgumentException("no ShippingInfo");

        this.shippingInfo = shippingInfo;
    }

    private void verifyNotYetShipped()
    {
        if (orderState != OrderState.PAYMENT_WAITING && orderState != OrderState.PREPARING)
        {
            throw new IllegalArgumentException("aleady shipped");
        }
    }

    private void setOrderLines(List<OrderLine> orderLineList)
    {
        verifyLeastOneOrMoeOrderLines(orderLineList);
        this.orderLineList = orderLineList;
        calculateTotalAmounts();
    }

    private void verifyLeastOneOrMoeOrderLines(List<OrderLine> orderLineList)
    {
        if (orderLineList == null || orderLineList.isEmpty())
            throw new IllegalArgumentException("no OrderLine");
    }

    private void calculateTotalAmounts()
    {
        this.totalAmounts = new Money(orderLineList.stream().mapToInt(x -> x.getAmounts()).sum());
    }

    public void changeShipped(){}
    public void changeShippingInfo(){}
    public void cancel(){}
    public void completePayment(){}

}
