package com.example.regexcrossword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class LetterChoiceFragment extends DialogFragment {
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_letterchoice,container,false);
        super.onCreateView(inflater, container, savedInstanceState);
        String values = getArguments().getString("values");
        TextView tv00 = (TextView) rootView.findViewById(R.id.btnChoice_0_0);
        tv00.setText(values.substring(0,1));
        TextView tv10 = (TextView) rootView.findViewById(R.id.btnChoice_1_0);
        tv10.setText(values.substring(1,2));
        TextView tv20 = (TextView) rootView.findViewById(R.id.btnChoice_2_0);
        tv20.setText(values.substring(2,3));
        TextView tv01 = (TextView) rootView.findViewById(R.id.btnChoice_0_1);
        tv01.setText(values.substring(3,4));
        TextView tv21 = (TextView) rootView.findViewById(R.id.btnChoice_2_1);
        tv21.setText(values.substring(4,5));
        TextView tv02 = (TextView) rootView.findViewById(R.id.btnChoice_0_2);
        tv02.setText(values.substring(5,6));
        TextView tv12 = (TextView) rootView.findViewById(R.id.btnChoice_1_2);
        tv12.setText(values.substring(6,7));
        TextView tv22 = (TextView) rootView.findViewById(R.id.btnChoice_2_2);
        tv22.setText(values.substring(7,8));
        return rootView;
    }
}
