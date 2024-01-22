package com.example.drawermen.ui.Photo;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.drawermen.R;
import com.example.drawermen.databinding.FragmentAddPhotoBinding;
import com.google.firebase.auth.FirebaseAuth;



import java.util.UUID;

public class AddPhoto extends Fragment {
    private static final int REQUEST_CODE=22;
    Button bttncam,bttnPay;
    private Uri ImageUri;


    private ImageView Image;
    private Bitmap bitmap,image;
    private String PhotoUri;

   ImageView imagebttn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_photo, container, false);
        bttncam=view.findViewById(R.id.bttncam);
        imagebttn=view.findViewById(R.id.imagebttn);
        bttnPay=view.findViewById(R.id.bttnPay);
        bttncam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,REQUEST_CODE);
            }
        });
        bttnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }

            private void selectImage() {
                Intent intent=new Intent();
                intent.setType("image/");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,22);
            }

        });
        imagebttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });



        return view;
    }

    private void uploadImage() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            imagebttn.setImageBitmap(photo);

    }
        else {
            Toast.makeText(getActivity(),"Cancelled",Toast.LENGTH_SHORT).show();
        }
}

}