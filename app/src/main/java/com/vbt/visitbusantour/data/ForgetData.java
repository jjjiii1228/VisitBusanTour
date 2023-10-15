package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class ForgetData {
    @SerializedName("authentication_code")
    String code;

    @SerializedName("email")
    String userEmail;

    public ForgetData(String email) {
        this.userEmail = email;
    }
}
