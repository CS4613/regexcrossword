package com.example.regexcrossword;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TutorialSelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorialselect);
    }
    public void loadTutorialActivity(View view) {
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }
}

