package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Money;
import com.ddd.dddstart.domain.ShippingInfo;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Order {

    private List<OrderLine> orderLineList;
    private Money totalAmounts;
    private ShippingInfo shippingInfo;
    private OrderState orderState;

    public Order(List<OrderLine> orderLineList, Money totalAmounts, ShippingInfo shippingInfo, OrderState orderState)
    {
        this.orderLineList = orderLineList;
        this.totalAmounts = totalAmounts;
        this.shippingInfo = shippingInfo;
        this.orderState = orderState;
    }

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

    public void cancel()
    {
        verifyNotYetShipped();
        this.orderState = OrderState.CANCELED;
    }

    // 출고 Check 메서드
    private void verifyNotYetShipped()
    {
        if (orderState != OrderState.PAYMENT_WAITING && orderState != OrderState.PREPARING)
        {
            throw new IllegalArgumentException("Already shipped");
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
        this.totalAmounts = new Money(orderLineList.stream().mapToInt(x -> x.getAmounts().getValue()).sum());
    }

    public void changeShipped(){}

    // 배송지 정보 변경
    public void changeShippingInfo(ShippingInfo newShippingInfo){
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }
    public void completePayment(){}

}
