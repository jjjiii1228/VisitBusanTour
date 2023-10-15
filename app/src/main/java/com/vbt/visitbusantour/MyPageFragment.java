package com.vbt.visitbusantour;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vbt.visitbusantour.data.InfoResponse;
import com.vbt.visitbusantour.network.RetrofitClient;
import com.vbt.visitbusantour.network.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPageFragment extends Fragment {

    private ServiceApi service;
    private  View view;
    private Button My_info;
    private Button Contact;
    private Button Terms;
    private TextView Name;
    private Button Log_out;
    private Button Delete_account;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_page, container, false);
        service = RetrofitClient.getClient().create(ServiceApi.class);


        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("test", MODE_PRIVATE);
        String accessToken = String.format("Bearer %s", sharedPreferences.getString("access_token", ""));
        Log.d("check access token", accessToken);
        startLogin(accessToken);

        My_info = (Button) view.findViewById(R.id.my_info);
        Contact = (Button) view.findViewById(R.id.contact);
        Terms = (Button) view.findViewById(R.id.terms);
        Log_out = (Button) view.findViewById(R.id.log_out);
        Delete_account = (Button) view.findViewById(R.id.delete_account);



        My_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), profile.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), contact_us.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        Terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Terms_conditions.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        Log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout(accessToken);
            }
        });

        return view;
    }
    public void Logout(String accessToken) {

        service.userInfo(accessToken).enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                InfoResponse result = response.body();
                String Oauth_provider = response.body().getOuath_provider();

                if(Oauth_provider =="None"){
                    SharedPreferences pref = getContext().getSharedPreferences("test", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.clear();
                    editor.commit();

                    Intent intent = new Intent(getActivity(), LoginGoogle.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
                else{


                }
            }
            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
            }
        });

    }
    public void startLogin(String accessToken) {

        service.userInfo(accessToken).enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                InfoResponse result = response.body();
//                Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                Name = (TextView) view.findViewById(R.id.name);
                String Oauth_provider = response.body().getOuath_provider();
                String name = response.body().getLast_name() +"  "+ response.body().getFirst_name();
                Name.setText(name);
            }
            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
            }
        });

    }

}