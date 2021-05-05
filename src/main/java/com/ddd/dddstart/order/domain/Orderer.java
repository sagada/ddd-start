package com.ddd.dddstart.order.domain;

import com.ddd.dddstart.common.model.Address;

import javax.persistence.*;

@Embeddable
public class Orderer {
    // MemberId 에 정의된 칼럼 이름을 변경하기 위해
    // @AttributeOverride 사용
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;
}
