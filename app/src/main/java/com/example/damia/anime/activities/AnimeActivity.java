package com.example.damia.anime.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.damia.anime.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        getSupportActionBar().hide();
    }
}
