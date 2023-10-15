package com.vbt.visitbusantour;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vbt.visitbusantour.activity.JoinActivity;
import com.vbt.visitbusantour.activity.LoginActivity;
import com.vbt.visitbusantour.data.CodeData;
import com.vbt.visitbusantour.data.CodeResponse;
import com.vbt.visitbusantour.data.JoinData;
import com.vbt.visitbusantour.data.JoinResponse;
import com.vbt.visitbusantour.data.LoginData;
import com.vbt.visitbusantour.data.LoginResponse;
import com.vbt.visitbusantour.network.RetrofitClient;
import com.vbt.visitbusantour.network.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Confirm_email extends AppCompatActivity {

    private EditText Code;
    private Button Confirm_btn;
    private String userEmail = null;
    private ServiceApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_email);

        service = RetrofitClient.getClient().create(ServiceApi.class);

        Intent intent = getIntent();
        userEmail = intent.getStringExtra("userEmail");
        Log.d("email",userEmail);

        Code = (EditText) findViewById(R.id.code);
        Confirm_btn = (Button) findViewById(R.id.confirm_btn);

        Confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCodeValid();
            }
        });
    }
    private void isCodeValid() {
        Code.setError(null);
        String confirm_code = Code.getText().toString();
        boolean cancel = false;
        View focusView = null;

        if(confirm_code.isEmpty()){
            Code.setError("Enter the code.");
            focusView = Code;
            cancel = true;
        }else if(!confirm_code_len(confirm_code)){
            Code.setError("Must be 4 characters long");
            focusView = Code;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            checkCode(new CodeData(userEmail, confirm_code));
            Log.d("isReal","");
        }
    }
    private boolean confirm_code_len(String confirm_code) {
        return confirm_code.length() == 4;
    }
    private void checkCode (CodeData data) {
        service.userCode(data).enqueue(new Callback<CodeResponse>() {
            @Override
            public void onResponse(Call<CodeResponse> call, Response<CodeResponse> response) {
                CodeResponse result = response.body();
//                Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();

                if (response.code() == 200) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(response.code() == 400){
//                    ErrorResponse errorResponse = (ResponseBody) response.errorBody();

                    Toast.makeText(Confirm_email.this, "Confirm code error", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<CodeResponse> call, Throwable t) {
                Toast.makeText(Confirm_email.this, "Login error", Toast.LENGTH_SHORT).show();
                Log.e("Login error", t.getMessage());

            }
        });
    }


}