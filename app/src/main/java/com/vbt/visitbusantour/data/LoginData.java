package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("email")
    String userEmail;

    @SerializedName("password")
    String userPwd;

    public LoginData(String userEmail, String userPwd) {
        this.userEmail = userEmail;
        this.userPwd = userPwd;
    }
}
