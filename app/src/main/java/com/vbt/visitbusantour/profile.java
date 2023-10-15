package com.vbt.visitbusantour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.vbt.visitbusantour.activity.LoginActivity;
import com.vbt.visitbusantour.data.CodeResponse;
import com.vbt.visitbusantour.data.InfoResponse;
import com.vbt.visitbusantour.data.LoginData;
import com.vbt.visitbusantour.data.LoginResponse;
import com.vbt.visitbusantour.network.RetrofitClient;
import com.vbt.visitbusantour.network.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile extends AppCompatActivity {

    private ServiceApi service;
    private TextView Name;
    private TextView Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        service = RetrofitClient.getClient().create(ServiceApi.class);


        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
        String accessToken = String.format("Bearer %s", sharedPreferences.getString("access_token", ""));
        Log.d("check access token", accessToken);
        startLogin(accessToken);
    }


    private void startLogin(String accessToken) {

        service.userInfo(accessToken).enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                InfoResponse result = response.body();
//                Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                Name = (TextView) findViewById(R.id.name);
                Email = (TextView) findViewById(R.id.email);

                String name = response.body().getLast_name() +"  "+ response.body().getFirst_name();
                String email = response.body().getEmail();

                Name.setText(name);
                Email.setText(email);
            }
            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
            }
        });
    }
}