package com.example.drawermen.ui.Label;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.drawermen.R;

public class AddLabel extends Fragment {


    EditText addtext;
    Button bttnlabel;

    LinearLayout checkBoxs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_label, container, false);
        addtext=view.findViewById(R.id.addtext);
        bttnlabel=view.findViewById(R.id.bttnlabel);
        checkBoxs=view.findViewById(R.id.checkBoxs);
        bttnlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText=addtext.getText().toString();
                if(!enteredText.isEmpty()){
                    addCheckbox(enteredText);
                    addtext.setText("");//Giriş kutusunu temizleme
                }
            }
        });



        return view;
    }

    private void addCheckbox(String enteredText) {
        CheckBox checkBox=new CheckBox(requireContext());
        checkBox.setText(enteredText);
        checkBoxs.addView(checkBox);

    }
}