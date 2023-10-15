package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class InfoResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("email")
    private String email;

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("ouath_provider")
    private String ouath_provider;

    @SerializedName("is_authorized")
    private String is_authorized;

    public int getCode() { return code; }

    public String getMessage() { return message; }

    public String getEmail() { return email; }

    public String getFirst_name() { return first_name; }

    public String getLast_name() { return last_name; }

    public String getOuath_provider() { return ouath_provider; }

    public String getIs_authorized() { return is_authorized; }
}

