package com.vbt.visitbusantour;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.NameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ClientProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.UrlEncodedFormEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.StringEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.EntityUtils;
import com.vbt.visitbusantour.activity.LoginActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginGoogle extends AppCompatActivity implements View.OnClickListener{

    GoogleSignInClient mGoogleSignInClient;
    private final int RC_SIGN_IN = 123;
    private static final String TAG = "LoginGoogle";
    SignInButton signBt;
    Button logoutBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_google);

        signBt = findViewById(R.id.sign_in_button);
        signBt.setOnClickListener(this);
//        logoutBt = findViewById(R.id.logoutBt);
//        logoutBt.setOnClickListener(this);

        // Visit Busan Pass 글자 색 변경
        TextView VisitBusan_txt = findViewById(R.id.visitBusan_txt);
        String text = "the Visit-Busan-Tour!";
        int startColor = ContextCompat.getColor(this, R.color.start);
        int endColor = ContextCompat.getColor(this, R.color.end);

        SpannableStringBuilder spnnable = new SpannableStringBuilder(text);
        spnnable.setSpan(new ToGradient(text, text, startColor, endColor), 0, text.length(), 0);
        VisitBusan_txt.setText(spnnable);

        Button Sign_login_btn = findViewById(R.id.sign_login_btn);
        Sign_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(LoginGoogle.this, gso);

        GoogleSignInAccount gsa = GoogleSignIn.getLastSignedInAccount(LoginGoogle.this);

        if (gsa != null && gsa.getId() != null) {

        }

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
//            case R.id.logoutBt:
//                mGoogleSignInClient.signOut()
//                        .addOnCompleteListener(this, task -> {
//                            Log.d(TAG, "onClick:logout success ");
//                            mGoogleSignInClient.revokeAccess()
//                                    .addOnCompleteListener(this, task1 -> Log.d(TAG, "onClick:revokeAccess success "));
//
//                        });
//                break;
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount acct = completedTask.getResult(ApiException.class);
            String idToken = acct.getIdToken();


            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

                Log.d(TAG, "handleSignInResult:personName "+personName);
                Log.d(TAG, "handleSignInResult:personGivenName "+personGivenName);
                Log.d(TAG, "handleSignInResult:personEmail "+personEmail);
                Log.d(TAG, "handleSignInResult:personId "+personId);
                Log.d(TAG, "handleSignInResult:personFamilyName "+personFamilyName);
                Log.d(TAG, "handleSignInResult:personPhoto "+personPhoto);

                // ID 토큰을 서버로 전송하는 AsyncTask 실행
                new SendIdTokenToServerTask().execute(idToken);

//                Intent mainIntent = new Intent(LoginGoogle.this, MainActivity.class);
//                startActivity(mainIntent);
//                finish();

            }
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.e(TAG, "signInResult:failed code=" + e.getStatusCode());

        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.4
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    // backend
    private class SendIdTokenToServerTask extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(LoginGoogle.this);
            progressDialog.setMessage("ID 토큰을 서버로 전송 중...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String idToken = params[0];
            String responseBody = null;

            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://13.209.92.60:8000/account/login/oauth/google");

//                StringEntity entity = new StringEntity("google_id_token = " + idToken, "UTF-8");
//                entity.setContentType("application/x-www-form-urlencoded");
//                httpPost.setEntity(entity);

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                nameValuePairs.add(new BasicNameValuePair("google_id_token", idToken));
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = httpClient.execute(httpPost);

                int statusCode = response.getStatusLine().getStatusCode();
                responseBody = EntityUtils.toString(response.getEntity());

            } catch (ClientProtocolException e) {
                Log.e(TAG, "Error sending ID token to backend.", e);
            } catch (IOException e) {
                Log.e(TAG, "Error sending ID token to backend.", e);
            }

            return responseBody;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();

            if (result != null) {
                Log.i(TAG, "Signed in as: " + result);
                // 서버로부터의 응답(result)에 따른 처리
            } else {
                Log.e(TAG, "Failed to send ID token to backend.");
                // 오류 처리
            }
        }
    }
}