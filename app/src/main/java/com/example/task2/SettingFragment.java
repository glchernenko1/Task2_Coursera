package com.example.task2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class SettingFragment extends Fragment {

    private RadioGroup radioGroup;
    private SharedPreferencesHelper mSharedPreferencesHelper;

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener =
            new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    RadioButton checkedRadioButton = (RadioButton) radioGroup
                            .findViewById(checkedId);
                    mSharedPreferencesHelper.setSearch(radioGroup.indexOfChild(checkedRadioButton));
                }
            };


    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setting_fragment, container, false);
        mSharedPreferencesHelper = new SharedPreferencesHelper(Objects.requireNonNull(getActivity()));
        radioGroup = v.findViewById(R.id.buttons);

        RadioButton savedCheckedRadioButton = (RadioButton) radioGroup
                .getChildAt(mSharedPreferencesHelper.getSearch());
        savedCheckedRadioButton.setChecked(true);
        radioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);


        return v;
    }
}
