package com.ddd.dddstart.order.domain;

public enum OrderState {
    PAYMENT_WAITING, // 결제 대기
    PREPARING, // 상품 준비
    SHIPPED, // 출고
    DELIVERING, // 배송중
    DELIVERY_COMPLETED, // 배송완료
    CANCELED; // 취소
}
