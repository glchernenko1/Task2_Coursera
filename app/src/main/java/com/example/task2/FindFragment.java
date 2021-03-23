package com.example.task2;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class FindFragment extends Fragment {
    private Button find;
    private EditText text;
    private SharedPreferencesHelper mSharedPreferencesHelper;

    public static FindFragment newInstance() {
        return new FindFragment();
    }

    private String finder() {
        switch (mSharedPreferencesHelper.getSearch()) {
            case 0:
                return "https://www.google.com/search?q=";
            case 1:
                return "https://www.yandex.ru/search/?text=";
            case 2:
                return "https://www.bing.com/search?q=";
            default:
                return "";
        }
    }

    private View.OnClickListener findOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(finder() + text.getText().toString()));
            startActivity(intent);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.find_fragment, container, false);
        find = v.findViewById(R.id.findButton);
        text = v.findViewById(R.id.text);
        mSharedPreferencesHelper = new SharedPreferencesHelper(Objects.requireNonNull(getActivity()));
        find.setOnClickListener(findOnClickListener);

        return v;
    }


}
