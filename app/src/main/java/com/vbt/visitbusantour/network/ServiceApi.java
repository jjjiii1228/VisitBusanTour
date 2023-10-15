package com.vbt.visitbusantour.network;


import com.vbt.visitbusantour.data.CodeData;
import com.vbt.visitbusantour.data.CodeResponse;
import com.vbt.visitbusantour.data.ForgetData;
import com.vbt.visitbusantour.data.ForgetResponse;
import com.vbt.visitbusantour.data.InfoResponse;
import com.vbt.visitbusantour.data.JoinData;
import com.vbt.visitbusantour.data.JoinResponse;
import com.vbt.visitbusantour.data.LoginData;
import com.vbt.visitbusantour.data.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ServiceApi {
    @POST("/account/login/visit-busan")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/account/sign-up")
    Call<JoinResponse> userJoin(@Body JoinData data);

    @POST("/account/authorize")
    Call<CodeResponse> userCode(@Body CodeData data);

    @POST("/account/member/find-passwd")
    Call<ForgetResponse> userForget(@Body ForgetData data);

    @GET("/account/member")
    Call<InfoResponse> userInfo(@Header("Authorization") String accessToken);
}
