package com.vbt.visitbusantour.activity;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vbt.visitbusantour.Confirm_email;
import com.vbt.visitbusantour.MainActivity;
import com.vbt.visitbusantour.MyPageFragment;
import com.vbt.visitbusantour.R;
import com.vbt.visitbusantour.data.ErrorResponse;
import com.vbt.visitbusantour.data.JoinData;
import com.vbt.visitbusantour.data.JoinResponse;
import com.vbt.visitbusantour.network.RetrofitClient;
import com.vbt.visitbusantour.network.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity {
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private EditText mPasswordConfirm;
    private EditText mNameView;
    private EditText mNameViewLast;
    private Button mJoinButton;
    private ProgressBar mProgressView;
    private ServiceApi service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.join_email);
        mPasswordView = (EditText) findViewById(R.id.join_password);
        mPasswordConfirm = (EditText) findViewById(R.id.join_password_confirm);
        mNameView = (EditText) findViewById(R.id.first_name);
        mNameViewLast = (EditText) findViewById(R.id.last_name);
        mJoinButton = (Button) findViewById(R.id.join_button);
        mProgressView = (ProgressBar) findViewById(R.id.join_progress);

        service = RetrofitClient.getClient().create(ServiceApi.class);

        mJoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptJoin();
            }
        });
    }

    private void attemptJoin() {
        mNameView.setError(null);
        mNameViewLast.setError(null);
        mEmailView.setError(null);
        mPasswordView.setError(null);
        mPasswordConfirm.setError(null);


        String first_name = mNameView.getText().toString();
        String last_name = mNameViewLast.getText().toString();
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String password_confirm = mPasswordConfirm.getText().toString();
        String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjkzNzA4MTg3LCJpYXQiOjE2OTI0MTIxODcsImp0aSI6ImE4Mjg4Zjk3N2ZmNzQ2ODZiZTJlY2JmYzBjODNjY2U3IiwidXNlcl9pZCI6MTN9.KmZcjYcr1v-7qbEDM5UmptrrxVUQIr0jVylY3Hah5xM";

        boolean cancel = false;
        View focusView = null;

        // 패스워드의 유효성 검사
        if (password.isEmpty()) {
            mPasswordView.setError("Enter your password.");
            focusView = mPasswordView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mPasswordView.setError("Must be at least 8 characters long.");
            focusView = mPasswordView;
            cancel = true;
        }

        //패스워드 일치 검사
        if (password_confirm.isEmpty()) {
            mPasswordConfirm.setError("Enter your password one more time.");
            focusView = mPasswordConfirm;
            cancel = true;
//        } else if (password != password_confirm) {
//            mPasswordConfirm.setError("Does not match.");
//            focusView = mPasswordConfirm;
//            cancel = true;
        }

        // 이메일의 유효성 검사
        if (email.isEmpty()) {
            mEmailView.setError("Enter your email.");
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError("Please enter a valid email including @.");
            focusView = mEmailView;
            cancel = true;
        }

        // 이름의 유효성 검사
        if (first_name.isEmpty()) {
            mNameView.setError("Enter your first name.");
            focusView = mNameView;
            cancel = true;
        }
        // 이름의 유효성 검사2
        if (last_name.isEmpty()) {
            mNameViewLast.setError("Enter your last name.");
            focusView = mNameView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startJoin(new JoinData(first_name,last_name, email, password));
            showProgress(true);
        }
    }

    private void startJoin(JoinData data) {
        service.userJoin(data).enqueue(new Callback<JoinResponse>() {
            @Override
            public void onResponse(Call<JoinResponse> call, Response<JoinResponse> response) {
                Log.v("response", response.toString());
                JoinResponse result = response.body();
//                Toast.makeText(JoinActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                showProgress(false);

                if (response.code() == 200) {
                    String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjkzNzA4MTg3LCJpYXQiOjE2OTI0MTIxODcsImp0aSI6ImE4Mjg4Zjk3N2ZmNzQ2ODZiZTJlY2JmYzBjODNjY2U3IiwidXNlcl9pZCI6MTN9.KmZcjYcr1v-7qbEDM5UmptrrxVUQIr0jVylY3Hah5xM";
                    SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences
                    editor.putString("access_token", access_token);
                    editor.commit();
                    Toast.makeText(JoinActivity.this, "저장", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getApplicationContext(), Confirm_email.class);
                    intent.putExtra("userEmail", mEmailView.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else if (response.code() == 400){
//                    ErrorResponse errorResponse = (ResponseBody) response.errorBody();
                    Toast.makeText(JoinActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                }
                else if (response.code() == 500){
//                    ErrorResponse errorResponse = (ResponseBody) response.errorBody();
                    Toast.makeText(JoinActivity.this, "dfklaljl", Toast.LENGTH_SHORT).show();
                    Log.d("500error",response.toString());

                }
            }

            @Override
            public void onFailure(Call<JoinResponse> call, Throwable t) {
                Toast.makeText(JoinActivity.this, "Register error", Toast.LENGTH_SHORT).show();
                Log.e("Register error", t.getMessage());
                showProgress(false);
            }
        });
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}