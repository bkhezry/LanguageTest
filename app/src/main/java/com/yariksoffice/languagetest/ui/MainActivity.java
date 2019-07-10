package com.yariksoffice.languagetest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import com.yariksoffice.languagetest.R;
import com.yariksoffice.languagetest.TestService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        findViewById(R.id.activity_1).setOnClickListener(v -> startActivity(new Intent(this, TestActivity1.class)));
        findViewById(R.id.activity_2).setOnClickListener(v -> startActivity(new Intent(this, TestActivity2.class)));
        findViewById(R.id.service).setOnClickListener(v -> startService(new Intent(this, TestService.class)));
        findViewById(R.id.settings).setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));
        SwitchCompat switchCompat = findViewById(R.id.dark_mode_switch);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    getDelegate().setLocalNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES);
                else
                    getDelegate().setLocalNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO);

            }
        });
        TextView tv = findViewById(R.id.hello);
        String date = SimpleDateFormat.getDateInstance().format(new Date());
        tv.setText(getString(R.string.hello, date));
    }
}