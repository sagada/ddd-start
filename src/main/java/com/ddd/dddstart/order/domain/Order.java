package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Money;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="purchase_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Embedded
    private Orderer orderer;

    @Embedded
    private ShippingInfo shippingInfo;

    @ElementCollection
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "total_amounts"))
    )
    private Money totalAmounts;

    private OrderState orderState;

    public Order(OrderLines orderLines, Money totalAmounts, ShippingInfo shippingInfo, OrderState orderState)
    {
        this.totalAmounts = totalAmounts;
        this.shippingInfo = shippingInfo;
        this.orderState = orderState;
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
