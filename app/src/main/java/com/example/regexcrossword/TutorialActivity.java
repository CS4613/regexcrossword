package com.example.regexcrossword;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TutorialActivity extends AppCompatActivity {
    public LetterChoiceFragment lcf = new LetterChoiceFragment();
    public Integer tutorial = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoral);
    }

    public void clickTutorialBox(View view) {
        lcf.show(getSupportFragmentManager(), "letterChoice");
    }


    /*
     *  nextTutorial is called when the button on the tutorial activity_tutoiral screen is clicked
     */
    public void nextTutorial(View view) {
        tutorial++;
        TextView upperRegexColumn = (TextView) findViewById(R.id.txtRegexColumn0);
        TextView leftRegexColumn = (TextView) findViewById(R.id.txtPaddingLeft0);
        TextView tutorialTextBox = (TextView) findViewById(R.id.tutorial_text);
        TextView categoryTextBox = (TextView) findViewById(R.id.textView);
        TextView levelTextBox = (TextView) findViewById(R.id.textView2);
        levelTextBox.setText("Tutorial: " + tutorial + "/6");

        switch (tutorial){
            //Or case
            case 0:
                upperRegexColumn.setText(R.string.or_tutoral_upper_regex);
                leftRegexColumn.setText(getResources().getString(R.string.or_tutoral_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.or_tutoral_text));
                categoryTextBox.setText("OR Symbol");
                break;
            //Range of Characters
            case 1:
                upperRegexColumn.setText(getResources().getString(R.string.range_of_char_tutoral_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.range_of_char_tutoral_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.range_of_char_tutoral_text));
                categoryTextBox.setText("Range of Characters");
                break;
            // Characters NOT to include
            case 2:
                upperRegexColumn.setText(getResources().getString(R.string.chars_not_to_include_tutoral_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.chars_not_to_include_tutoral_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.chars_not_to_include_tutoral_text));
                categoryTextBox.setText("Characters Not to Include");
                break;
            //Zero or more
            case 3:
                upperRegexColumn.setText(getResources().getString(R.string.zero_or_more_tutoral_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.zero_or_more_tutoral_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.zero_or_more_tutoral_text));
                categoryTextBox.setText("Zero or More Characters");
                break;
            //Zero or one
            case 4:
                upperRegexColumn.setText(getResources().getString(R.string.zero_or_one_tutoral_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.zero_or_one_tutoral_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.zero_or_one_tutoral_text));
                categoryTextBox.setText("Zero or one Characters");
                break;
            //One or more
            case 5:
                upperRegexColumn.setText(getResources().getString(R.string.one_or_more_tutoral_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.one_or_more_tutoral_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.one_or_more_tutoral_text));
                categoryTextBox.setText("One or More Characters");
                break;
            //Backreference
            case 6:
                upperRegexColumn.setText(getResources().getString(R.string.backreference_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.backreference_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.backreference_tutoral_text));
                categoryTextBox.setText("Back Reference");
                tutorial = 0;
                break;
            default:
                upperRegexColumn.setText(R.string.or_tutoral_upper_regex);
                leftRegexColumn.setText(R.string.or_tutoral_left_regex);
                tutorialTextBox.setText(R.string.or_tutoral_text);
                break;
        }
    }


}
