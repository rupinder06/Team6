package com.example.team6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DataActivity extends AppCompatActivity {

    ImageView img;
    TextView txtdesc,follower,following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        txtdesc=findViewById(R.id.txtdesc);
        follower=findViewById(R.id.txtfollowers);
        following=findViewById(R.id.txtfollowing);


        Intent i =getIntent();
        Products p = i.getParcelableExtra("data");

        txtdesc.setText(p.getDescription());


    }
}
