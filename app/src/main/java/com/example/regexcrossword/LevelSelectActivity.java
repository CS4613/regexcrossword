package com.example.regexcrossword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LevelSelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelselect);
    }
 /*   public void loadPuzzleActivity(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Level: " + String.valueOf(level) +
                            " Difficulty: " + String.valueOf(difficulty);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent intent = new Intent(this, puzzleActivity.class);
        intent.putExtra("level",level);
        intent.putExtra("difficulty",difficulty);
        startActivity(intent);
    }
 */

    public void selected00(View view) {
        int level = 0;
        int difficulty = 0;
        Context context = getApplicationContext();
        CharSequence text = "Level: " + String.valueOf(level) +
                " Difficulty: " + String.valueOf(difficulty);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent intent = new Intent(this, puzzleActivity.class);
        intent.putExtra("level",level);
        intent.putExtra("difficulty",difficulty);
        startActivity(intent);
    }

}
