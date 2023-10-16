package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CourseData {
    @SerializedName("authentication_code")
    String code;
    @SerializedName("email")
    String userEmail;
    @SerializedName("companion")
    List<CourseDetailData> companion;
    @SerializedName("schedule")
    String schedule;
    @SerializedName("activity")
    String activity;
    @SerializedName("attraction")
    String attraction;
    @SerializedName("keyword")
    String keyword;



    // companion 에 TRAVELIGN_COMPANION_STYLE가 들어간다고 생각하면 되요!
    public CourseData(ArrayList<String> companion, String schedule, String activity,
                      String attraction, String keyword) {

        this.userEmail = userEmail;
        this.companion = createCourseDetailList(companion);
        this.schedule = schedule;
        this.activity = activity;
        this.attraction = attraction;
        this.keyword = keyword;
    }

    private List<CourseDetailData> createCourseDetailList(ArrayList<String> data) {
        List<CourseDetailData> detailDataList = new ArrayList();

        for (int i = 0; i < data.size(); i++) {
            detailDataList.add(new CourseDetailData(data.get(i)));
        }

        return detailDataList;
    }
}