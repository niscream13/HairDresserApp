package com.example.hairdresserapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    RecordsFragment recordsFragment = new RecordsFragment();
    HistoryFragment historyFragment = new HistoryFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, recordsFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() ==R.id.records) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, recordsFragment).commit();
                return true;
            }
            else if (menuItem.getItemId() == R.id.history) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, historyFragment).commit();
                return true;
            }
            else if (menuItem.getItemId() == R.id.settings) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, settingsFragment).commit();
                return true;
            }

            return false;
        });
    }
}