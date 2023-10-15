package com.vbt.visitbusantour;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyCourseFragment extends Fragment {

        private View view;
        private Button myCourse_btn;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_my_course, container, false);

            myCourse_btn = (Button) view.findViewById(R.id.make_course_btn); //fragment에서 findViewByid는 view.을 이용해서 사용

            myCourse_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), CourseMaking_Splash.class); //fragment라서 activity intent와는 다른 방식
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
            });
            return view;
        }
}