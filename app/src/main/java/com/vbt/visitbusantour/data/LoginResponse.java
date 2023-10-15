package com.vbt.visitbusantour.data;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("userId")
    private int userId;

    @SerializedName("email")
    private String email;

    @SerializedName("jwt_token")
    private TokenResponse jwtToken;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() { return email; }

    public TokenResponse getJwtToken() { return jwtToken; }
}
