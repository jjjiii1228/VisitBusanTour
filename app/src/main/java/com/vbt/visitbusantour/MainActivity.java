package com.vbt.visitbusantour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    HomeFragment activityHome;
    MyCourseFragment activityMycourse;
    MyPageFragment activityMypage;
    VisitBusanFragment activityVisitbusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityHome = new HomeFragment();
        activityMycourse = new MyCourseFragment();
        activityMypage = new MyPageFragment();
        activityVisitbusan = new VisitBusanFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, activityHome).commit();
        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.first_tab) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, activityHome).commit();
                    return true;
                } else if (itemId == R.id.second_tab) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, activityVisitbusan).commit();
                    return true;
                } else if (itemId == R.id.third_tab) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, activityMycourse).commit();
                    return true;
                } else if (itemId == R.id.fourth_tab) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, activityMypage
                    ).commit();
                    return true;
                }
                return false;
            }
        });
    }
}