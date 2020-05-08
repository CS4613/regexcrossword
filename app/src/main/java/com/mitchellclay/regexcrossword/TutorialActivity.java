package com.mitchellclay.regexcrossword;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TutorialActivity extends AppCompatActivity {
    public LetterChoiceFragment lcf = new LetterChoiceFragment();
    public Integer tutorial = 0;
    public String [] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoral);
    }

    /**
     *  gridClicked is called when user click on a grid square during the tutorial. A letter choice
     *  screen in then shown which allows the user to chose a letter.
     **/
    public void gridClicked(View view){
        Bundle bundle = new Bundle();
        String data = "ABCDEFGH";
        bundle.putString("values", data);
        lcf.setArguments(bundle);
        lcf.show(getSupportFragmentManager(), "letterChoice");
    }

    /**
     *  letterChoice is called when user click on a letter to choose during the tutorial.
     *  The letter chosen is then used to updated the square
     **/
    public void letterChoice(View view) {
        String choice = (String) view.getTag();
        TextView answerSquare = (TextView) findViewById(R.id.txtGrid00);
        answerSquare.setText(" " + choice);
        lcf.dismiss();
    }

    /**
     *  nextTutorialButtonClicked is called when the next button on the tutorial
     *  activity_tutoiral screen is clicked
     **/
    public void nextTutorialButtonClicked(View view) {
        if(tutorial == 6){
            tutorial = 0;
        }
        else {
            tutorial++;
        }
        updateTutorialScreen(view);
    }

    /**
     *  prevTutorialButtonClicked is called when the previous button on the tutorial
     *  activity_tutoiral screen is clicked
     **/
    public void prevTutorialButtonClicked(View view) {
        if(tutorial == 0){
            tutorial = 6;
        }
        else {
            tutorial--;
        }
        updateTutorialScreen(view);
    }

    /**
     *  updateTutorialScreen is called by the functions nextTutorialButtonClicked and
     *  prevTutorialButtonClicked which are called when either button on the tutorial
     *  activity_tutoiral screen is clicked
     **/
    private void updateTutorialScreen(View view){
        TextView upperRegexColumn = (TextView) findViewById(R.id.txtRegexColumn0);
        TextView leftRegexColumn = (TextView) findViewById(R.id.txtPaddingLeft0);
        TextView tutorialTextBox = (TextView) findViewById(R.id.tutorial_text);
        TextView categoryTextBox = (TextView) findViewById(R.id.textCategory);
        TextView levelTextBox = (TextView) findViewById(R.id.textDifficulty);
        levelTextBox.setText("Tutorial: " + tutorial + "/6");

        switch (tutorial){
            //Or case
            case 0:
                upperRegexColumn.setText(R.string.or_tutorial_upper_regex);
                leftRegexColumn.setText(getResources().getString(R.string.or_tutorial_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.or_tutorial_text));
                categoryTextBox.setText("OR Symbol");
                break;
            //Range of Characters
            case 1:
                upperRegexColumn.setText(getResources().getString(R.string.range_of_char_tutorial_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.range_of_char_tutorial_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.range_of_char_tutoral_text));
                categoryTextBox.setText("Range of Characters");
                break;
            // Characters NOT to include
            case 2:
                upperRegexColumn.setText(getResources().getString(R.string.chars_not_to_include_tutorial_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.chars_not_to_include_tutoral_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.chars_not_to_include_tutorial_text));
                categoryTextBox.setText("Characters Not to Include");
                break;
            //Zero or more
            case 3:
                upperRegexColumn.setText(getResources().getString(R.string.zero_or_more_tutorial_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.zero_or_more_tutorial_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.zero_or_more_tutorial_text));
                categoryTextBox.setText("Zero or More Characters");
                break;
            //Zero or one
            case 4:
                upperRegexColumn.setText(getResources().getString(R.string.zero_or_one_tutorial_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.zero_or_one_tutorial_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.zero_or_one_tutorial_text));
                categoryTextBox.setText("Zero or one Characters");
                break;
            //One or more
            case 5:
                upperRegexColumn.setText(getResources().getString(R.string.one_or_more_tutorial_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.one_or_more_tutorial_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.one_or_more_tutorial_text));
                categoryTextBox.setText("One or More Characters");
                break;
            //Backreference
            case 6:
                upperRegexColumn.setText(getResources().getString(R.string.backreference_upper_regex));
                leftRegexColumn.setText(getResources().getString(R.string.backreference_left_regex));
                tutorialTextBox.setText(getResources().getString(R.string.backreference_tutorial_text));
                categoryTextBox.setText("Back Reference");
                break;
            default:
                tutorial = 0;
                upperRegexColumn.setText(R.string.or_tutorial_upper_regex);
                leftRegexColumn.setText(R.string.or_tutorial_left_regex);
                tutorialTextBox.setText(R.string.or_tutorial_text);
                break;
        }
    }
}
