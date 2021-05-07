package com.ddd.dddstart.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image{

    public InternalImage() {
    }

    public InternalImage(String path) {
        super(path);
    }

    @Override
    public String getURL() {
        return null;
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnailURL() {
        return null;
    }
}
