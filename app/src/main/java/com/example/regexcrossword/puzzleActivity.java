package com.example.regexcrossword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class puzzleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputStream in = getResources().openRawResource(R.raw.puzzledata);
        InputStreamReader ir = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(ir);
        String readLine = null;
        try {
            readLine = br.readLine();
        } catch (IOException e) {
            Log.d("Error", "Can't read data file!");
            e.printStackTrace();
        }
        while(readLine != null)
        {
            // read one line and store into array between each category
            String [] data = readLine.split(";"); //diff(int)|level(int)|possibleLetter|x|y|solution

            // get the integer difficulty data
            int diff = Integer.parseInt(data[0]);
            Log.d("Difficulty", String.valueOf(diff));

            // get the integer level data
            int level = Integer.parseInt(data[1]);
            System.out.println("Level: " + level);

            // this is possible letter
            System.out.println("Possible Letter: " + data[2]);

            // split the horizontal values
            String [] x = data[3].split("`");
            System.out.print("X values: ");
            for(int i = 0; i < x.length; i++)
                System.out.print(x[i] + "  ");
            System.out.println();

            // split the verticle values
            String [] y = data[4].split("`");
            System.out.print("Y values: ");
            for(int i = 0; i < y.length; i++)
                System.out.print(y[i] + "  ");
            System.out.println();

            // print out solution
            System.out.println("Solution: " + data[5]);

            // end of one data "one line read"
            System.out.println("end\n");

            // get the next line
            try {
                readLine = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_puzzle);
    }

    public void checkPuzzleSolution(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Coming soon!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
