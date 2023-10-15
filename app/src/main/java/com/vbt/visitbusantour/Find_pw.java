package com.vbt.visitbusantour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vbt.visitbusantour.activity.LoginActivity;
import com.vbt.visitbusantour.data.CodeData;
import com.vbt.visitbusantour.data.CodeResponse;
import com.vbt.visitbusantour.data.ForgetData;
import com.vbt.visitbusantour.data.ForgetResponse;
import com.vbt.visitbusantour.network.RetrofitClient;
import com.vbt.visitbusantour.network.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Find_pw extends AppCompatActivity {

    private EditText UserEmail;
    private ServiceApi service;
    private Button Confirm_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw);

        service = RetrofitClient.getClient().create(ServiceApi.class);


        UserEmail = (EditText) findViewById(R.id.userEmail);
        Confirm_btn = (Button) findViewById(R.id.confirm_btn);

        Confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEmailValid();
            }
        });
    }
    private void isEmailValid() {
        UserEmail.setError(null);
        String email = UserEmail.getText().toString();
        boolean cancel = false;
        View focusView = null;

        if(email.isEmpty()){
            UserEmail.setError("Enter the email.");
            focusView = UserEmail;
            cancel = true;
        }else if(!isReal(email)){
            UserEmail.setError("Please enter a valid email including @.");
            focusView = UserEmail;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            checkCode(new ForgetData(email));
            Log.d("isReal","");
        }
    }
    private void checkCode (ForgetData data) {
        service.userForget(data).enqueue(new Callback<ForgetResponse>() {
            @Override
            public void onResponse(Call<ForgetResponse> call, Response<ForgetResponse> response) {
                ForgetResponse result = response.body();
//                Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();

                if (response.code() == 200) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(response.code() == 400){
//                    ErrorResponse errorResponse = (ResponseBody) response.errorBody();
//                    Toast.makeText(Confirm_email.this, "Confirm code error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ForgetResponse> call, Throwable t) {
//                Toast.makeText(Confirm_email.this, "Login error", Toast.LENGTH_SHORT).show();
                Log.e("Login error", t.getMessage());
            }
        });
    }
    private boolean isReal(String email) {
        return email.contains("@");
    }

}