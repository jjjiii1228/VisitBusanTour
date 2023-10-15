package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class CourseData {
    @SerializedName("authentication_code")
    String code;
    @SerializedName("email")
    String userEmail;
    @SerializedName("companion")
    String companion;
    @SerializedName("schedule")
    String schedule;
    @SerializedName("activity")
    String activity;
    @SerializedName("attraction")
    String attraction;
    @SerializedName("keyword")
    String keyword;




    public CourseData(String companion, String schedule, String activity,
                      String attraction, String keyword) {

        this.userEmail = userEmail;
        this.companion = companion;
        this.schedule = schedule;
        this.activity = activity;
        this.attraction = attraction;
        this.keyword = keyword;
    }
}