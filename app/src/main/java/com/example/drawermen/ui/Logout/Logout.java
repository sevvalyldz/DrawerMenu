package com.example.drawermen.ui.Logout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.drawermen.R;

public class Logout extends Fragment {

Button bttncıkıs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logout, container, false);
        bttncıkıs=view.findViewById(R.id.bttncıkıs);
        bttncıkıs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }

            private void logout() {
                getActivity().finish();
            }

        });

        return view; // Add this line to return the inflated view
    }
}