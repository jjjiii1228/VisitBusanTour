package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class JoinData{
    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("email")
    private String userEmail;

    @SerializedName("password")
    private String userPwd;

    public JoinData(String first_name, String last_name, String userEmail, String userPwd) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
    }
}
