package com.example.regexcrossword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LevelSelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelselect);
    }
    public void loadPuzzleActivity(View view) {
        Intent intent = new Intent(this, puzzleActivity.class);
        startActivity(intent);
    }
}
