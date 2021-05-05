package com.ddd.dddstart.product.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type")
@Getter
@Table(name = "image")
public abstract class Image {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    protected Image(){}

    public Image(String path)
    {
        this.path = path;
        this.uploadTime = LocalDateTime.now();
    }

    public abstract String getURL();
    public abstract boolean hasThumbnail();
    public abstract String getThumbnailURL();
}
