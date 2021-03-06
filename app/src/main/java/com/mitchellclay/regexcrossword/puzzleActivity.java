package com.mitchellclay.regexcrossword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.Integer.*;

public class puzzleActivity extends AppCompatActivity {
    public String position;
    public LetterChoiceFragment lcf = new LetterChoiceFragment();
    public int difficulty;
    public int level;
    public String [] data;
    public String [] x;
    public String [] y;
    int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        Context context = getApplicationContext();
        Intent intent = getIntent();
        difficulty = intent.getIntExtra("difficulty", 0);
        level = intent.getIntExtra("level", 0);

        InputStream in = getResources().openRawResource(R.raw.puzzledata);
        InputStreamReader ir = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(ir);
        boolean found = false;
        String readLine = null;

        try {
            readLine = br.readLine();
        } catch (IOException e) {
            Log.d("Error", "Can't read data file!");
            e.printStackTrace();
        }

        while(readLine != null && !found)
        {
            // read one line and store into array between each category
            data = readLine.split(";"); //diff(int)|level(int)|possibleLetter|x|y|solution

            // get the integer difficulty data
            int diff = parseInt(data[0]);
            if (diff == difficulty) {

                // get the integer level data
                int lev = parseInt(data[1]);
                if (lev == level) {
                    found = true;
                    Log.d("Found: ", "true!");
                    // this is possible letter
                    System.out.println("Possible Letter: " + data[2]);

                    // split the horizontal values
                    x = data[3].split("`");
                    System.out.print("X values: ");
                    for (int i = 0; i < x.length; i++)
                        System.out.print(x[i] + "  ");
                    System.out.println();

                    // split the vertical values
                    y = data[4].split("`");
                    System.out.print("Y values: ");
                    for (int i = 0; i < y.length; i++)
                        System.out.print(y[i] + "  ");
                    System.out.println();

                    // print out solution
                    System.out.println("Solution: " + data[5]);

                }
                else {
                    // get the next line
                    try {
                        readLine = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                // get the next line
                try {
                    readLine = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_puzzle);
    }

    protected void onStart() {
        int catid = getResources().getIdentifier("category"+level+"_name", "string", getPackageName());
        TextView cattv = (TextView) findViewById(R.id.textCategory);
        cattv.setText(catid);

        int diffid = getResources().getIdentifier("difficulty"+difficulty+"_name", "string", getPackageName());
        TextView levtv = (TextView) findViewById(R.id.textDifficulty);
        levtv.setText(diffid);

        if (difficulty == 0) {
            size = 2;
        }
        if (difficulty == 1) {
            size = 4;
        }
        if (difficulty == 2) {
            size = 8;
        }
        // Tag validate button with puzzle size to pass to validation function
        ((TextView) findViewById(R.id.btnValidate)).setTag(size);
            // Hide unused elements
            for (int i = size; i < 8; i++) {
                int resID = getResources().getIdentifier("txtRegexColumn"+i,
                        "id", getPackageName());
                ((TextView)findViewById(resID)).setVisibility(TextView.GONE);
                resID = getResources().getIdentifier("txtPaddingLeft"+i,
                        "id", getPackageName());
                ((TextView)findViewById(resID)).setVisibility(TextView.GONE);
                resID = getResources().getIdentifier("txtPaddingRight"+i,
                        "id", getPackageName());
                ((TextView)findViewById(resID)).setVisibility(TextView.GONE);
            }
            for (int i = 0; i < 8; i++) {
                for (int j = size; j < 8; j++) {
                    int resID = getResources().getIdentifier("txtGrid" + j + i,
                            "id", getPackageName());
                    ((TextView) findViewById(resID)).setVisibility(TextView.GONE);
                    resID = getResources().getIdentifier("txtGrid" + i + j,
                            "id", getPackageName());
                    ((TextView) findViewById(resID)).setVisibility(TextView.GONE);
                    Log.d("Hiding: ", "txtGrid" + j + i);
                    Log.d("Hiding: ", "txtGrid" + i + j);
                }
            }
            // Populate regex columns and rows
            for (int i = 0; i < size; i++) {
                int resID = getResources().getIdentifier("txtRegexColumn" + i,
                        "id", getPackageName());
                ((TextView) findViewById(resID)).setText(x[i]);
                resID = getResources().getIdentifier("txtPaddingLeft" + i,
                        "id", getPackageName());
                ((TextView) findViewById(resID)).setText(y[i]);
            }
        super.onStart();
    }

    public void checkPuzzleSolution(View view) {
        String userSolution = "";
        int size = Integer.parseInt(findViewById(R.id.btnValidate).getTag().toString());
        CharSequence text = "";

        Log.d("Puzzle size: ", Integer.toString(size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int resID = getResources().getIdentifier("txtGrid"+ j + i,
                        "id", getPackageName());
                Log.d("Checking: ", "txtGrid"+ j + i);
                String tmp = ((TextView)findViewById(resID)).getText().toString();
                Log.d("Temp: ", tmp);
                userSolution = userSolution + tmp;
            }
        }
        Log.d("userSolution: ", String.valueOf(userSolution));
        Context context = getApplicationContext();

        if (userSolution.compareTo(data[5]) != 0) {
            text = "Incorrect! Try Again!";
        }
        else {
            text = "Correct!";
        }
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void letterChoice(View view) {
        String choice = (String) view.getTag();
        updateTextView(choice, position);
        lcf.dismiss();
    }

    private void updateTextView(final String s, final String gridPosition) {
        puzzleActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int resID = getResources().getIdentifier("txtGrid"+gridPosition,
                        "id", getPackageName());
                TextView tv = (TextView) findViewById(resID);
                tv.setText(s);
            }
        });
    }

    public void gridClicked(View view){
        position = (String) view.getTag();
        Log.d("Clicked: ", position);
        Bundle bundle = new Bundle();
        bundle.putString("values", data[2]);
        lcf.setArguments(bundle);
        lcf.show(getSupportFragmentManager(), "letterChoice");
    }
}
