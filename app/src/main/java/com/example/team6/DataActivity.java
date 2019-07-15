package com.example.team6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class DataActivity extends AppCompatActivity {


    TextView txtdesc, txtfollow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        txtdesc = findViewById(R.id.txtdesc);
        txtfollow = findViewById(R.id.txtfollow);
        String couny = new String();

        Intent in = getIntent();
        Products p = in.getParcelableExtra("data");

        txtdesc.setText(p.getDescription());
        //  txtfollow.setText(p.getFollowers_url());

        String link = p.getFollowers_url();
        //String link =getResources().getString(R.string.link);

        try {
            String myjson = new Syncdata().execute(link).get();

            System.out.println("Bhakti JSON:" + myjson);


            // JSONObject mainobj = new JSONObject(myjson);
            //  JSONArray products = mainobj.getJSONArray("products");


            JSONArray followers = new JSONArray(myjson);

            couny = String.valueOf(followers.length());
           /* for(int i =0;i<=30;i++)
            {
               *//* JSONObject childobj = products.getJSONObject(i);
                System.out.println("childObj" + i);
                String name = childobj.getString("name");
                String avatar_url = childobj.getJSONObject("owner").getString("avatar_url");
                String followers_url = childobj.getJSONObject("owner").getString("followers_url");
                String description =childobj.getString("description");
*//*

              //  pro.add(new Products(name, avatar_url,description,followers_url));

            }
*/


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        txtfollow.setText(couny);
    }
}