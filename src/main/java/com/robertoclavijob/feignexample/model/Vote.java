package com.robertoclavijob.feignexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {
    private String imageId;
    private String subId;
    private Integer value;

    @JsonProperty("image_id")
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @JsonProperty("sub_id")
    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

//    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
