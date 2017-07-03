package com.akquinet.model.Images;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by CLE on 02.07.17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaxDimensions {


    private Integer width;
    private Integer height;

    public MaxDimensions() {
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
