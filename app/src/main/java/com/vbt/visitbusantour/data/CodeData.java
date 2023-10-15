package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class CodeData {
    @SerializedName("authentication_code")
    String code;

    @SerializedName("email")
    String userEmail;

    public CodeData(String userEmail, String confirm_code) {
        this.code = confirm_code;
        this.userEmail = userEmail;
    }
}