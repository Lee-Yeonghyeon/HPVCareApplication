package com.example.hpvcareapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    Fragment hospitalFragment;
    Fragment informationFragment;
    Fragment postFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        hospitalFragment = new HospitalFragment();
        informationFragment = new InformationFragment();
        postFragment = new PostFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;

                    case R.id.hospitalItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, hospitalFragment).commit();
                        return true;

                    case R.id.informationItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, informationFragment).commit();
                        return true;

                    case R.id.postItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, postFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}