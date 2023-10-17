package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class CourseDetailData {
    @SerializedName("name")
    String detailName;


    public CourseDetailData(String detailName) {
        this.detailName = detailName;
    }
}