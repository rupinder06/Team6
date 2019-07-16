package com.example.team6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DataActivity extends AppCompatActivity {


    TextView txtdesc,txtfollowing,txtowner;
    TextView txtfollow;
    ArrayList<Products> pro;
    ImageView profile;
    String couny = new String();
    String count = new String();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        txtdesc = findViewById(R.id.txtdesc);
        txtfollow = findViewById(R.id.txtfollow);
        profile=findViewById(R.id.profile);
        txtowner=findViewById(R.id.txtlogin);
        txtfollowing=findViewById(R.id.txtfollowing);



        Intent in = getIntent();
        Products p = in.getParcelableExtra("data");

        txtdesc.setText(p.getDescription());


        //  txtfollow.setText(p.getFollowers_url());

        String link = p.getFollowers_url();
        String following = p.getFollowing_url();

        //String link =getResources().getString(R.string.link);

        try {
            String myjson = new Syncdata().execute(link).get();

            System.out.println("Bhakti JSON:" + myjson);


            JSONArray followers = new JSONArray(myjson);

          couny = String.valueOf(followers.length());
          count = String.valueOf(following.length());


           for(int i =0;i<=30;i++)
            {
                JSONObject folo = followers.getJSONObject(i);
                System.out.println("folo" + i);
                String followers_url = folo.getJSONObject("owner").getString("followers_url");
                String avatar_url = folo.getJSONObject("owner").getString("avatar_url");



                pro.add(new Products(followers_url,avatar_url));

            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        txtfollow.setText(couny);
        txtfollowing.setText(count);
       txtowner.setText(p.getLogin());
        Picasso.get().load(p.getAvatar_url()).into(profile);

    }
}