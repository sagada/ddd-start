package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Money;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name ="purchase_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Embedded
    private OrderLines orderLines;

    @Embedded
    private Money totalAmounts;

    @Embedded
    private ShippingInfo shippingInfo;
    private OrderState orderState;

    public Order(OrderLines orderLines, Money totalAmounts, ShippingInfo shippingInfo, OrderState orderState)
    {
        this.orderLines = orderLines;
        this.totalAmounts = totalAmounts;
        this.shippingInfo = shippingInfo;
        this.orderState = orderState;
    }

    public void changeOrderLines(List<OrderLine> newLines)
    {
        orderLines.changeOrderLines(newLines);
        this.totalAmounts = orderLines.getTotalAmounts();
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
//
//    private void setOrderLines(List<OrderLine> orderLineList)
//    {
//        verifyLeastOneOrMoeOrderLines(orderLineList);
//        this.orderLines = orderLineList;
//        calculateTotalAmounts();
//    }

    private void verifyLeastOneOrMoeOrderLines(List<OrderLine> orderLineList)
    {
        if (orderLineList == null || orderLineList.isEmpty())
            throw new IllegalArgumentException("no OrderLine");
    }

//    private void calculateTotalAmounts()
//    {
//        int sum = orderLines.stream()
//                .mapToInt(ol -> ol.getAmounts() * ol.getPrice())
//                .sum();
//
//        this.totalAmounts = new Money(sum);
//    }

    public void changeShipped(){}

    // 배송지 정보 변경
    public void changeShippingInfo(ShippingInfo newShippingInfo){
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }
    public void completePayment(){}

}
