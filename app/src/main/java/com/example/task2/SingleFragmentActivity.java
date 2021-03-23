package com.example.task2;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, getFragment()).commit();
        }

    }

    protected abstract Fragment getFragment();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showMessage(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                showMessage(R.string.exit);
                finish();
                break;
            case R.id.find:
                showMessage(R.string.find);
                getFragmentManager().beginTransaction().add(R.id.fragmentContainer, FindFragment.newInstance()).addToBackStack(FindFragment.class.getName()).commit();
                break;
            case R.id.setting:
                showMessage(R.string.setting);
                getFragmentManager().beginTransaction().add(R.id.fragmentContainer, SettingFragment.newInstance()).addToBackStack(SettingFragment.class.getName()).commit();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}