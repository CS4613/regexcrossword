package com.example.regexcrossword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadLevelSelectActivity(View view) {
        Intent intent = new Intent(this, LevelSelectActivity.class);
        startActivity(intent);
    }
}
