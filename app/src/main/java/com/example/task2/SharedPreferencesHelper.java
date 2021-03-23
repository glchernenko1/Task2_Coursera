package com.example.task2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    public static final String SHARED_PREFER_FIND = "SHARED_PREFER_FIND";
    public static final String KEY_FIND = "KEY_FIND";

    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREFER_FIND, Context.MODE_PRIVATE);
    }

    public int getSearch() {
        return mSharedPreferences.getInt(KEY_FIND, 0);
    }

    public void setSearch(int add) {
        mSharedPreferences.edit().putInt(KEY_FIND, add).apply();
    }


}
