package com.example.team6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DataActivity extends AppCompatActivity {

    ImageView img;
    TextView desc,follower,following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        img=findViewById(R.id.profile);
        desc=findViewById(R.id.desc);
        follower=findViewById(R.id.txtfollowers);
        following=findViewById(R.id.txtfollowing);

        Intent i =getIntent();
        Products p = i.getParcelableExtra("data");

        following.setText(p.getFollowing());
        follower.setText(p.getFollower());
        desc.setText(p.getDescription());



    }
}
