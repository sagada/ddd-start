package com.ddd.dddstart.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MemberId implements Serializable {
    @Column(name = "member_id")
    private String id;
}
