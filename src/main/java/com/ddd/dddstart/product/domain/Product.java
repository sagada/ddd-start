package com.ddd.dddstart.product.domain;

import com.ddd.dddstart.common.model.Money;
import com.ddd.dddstart.order.domain.MoneyConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    private String name;
    private String detail;

//    @Convert(converter = MoneyConverter.class)
//    private Money price;
    public void changeImages(List<Image> newImages)
    {
        images.clear();
        images.addAll(newImages);
    }

    public Product(String name, String detail, List<Image> images) {
        this.name = name;
        this.detail = detail;
        this.images.addAll(images);
    }

}
