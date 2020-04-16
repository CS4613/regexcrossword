package com.example.regexcrossword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LevelSelectActivity extends AppCompatActivity {
    public String leveltag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelselect);
    }

    public void selectedLevel(View view) {
        leveltag = (String) view.getTag();
        int difficulty = Integer.parseInt(leveltag.substring(0,1));
        int level = Integer.parseInt(leveltag.substring(1,2));

        Intent intent = new Intent(this, puzzleActivity.class);
        intent.putExtra("level",level);
        intent.putExtra("difficulty",difficulty);
        startActivity(intent);
    }

}
