package com.ddd.dddstart.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EI")
public class ExternalImage extends Image{

    public ExternalImage() {
    }

    public ExternalImage(String path) {
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
