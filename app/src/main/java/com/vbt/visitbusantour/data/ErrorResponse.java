package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("error_code")
    private String code;

    @SerializedName("error_msg")
    private String message;

    @SerializedName("error_detail")
    private String detail;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
