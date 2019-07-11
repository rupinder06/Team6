package com.example.team6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class FirstPage extends AppCompatActivity {

    ArrayList<Products> pro;
    Listadpt adpt;
    ListView lstv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        pro =new ArrayList<>();
        lstv=findViewById(R.id.lst_products);

        String link = "https://api.github.com/repositories";
       try
       {
           String myjson = new Syncdata().execute(link).get();

           System.out.println("MainActivity :"+myjson);

           JSONObject mainObj = new JSONObject(myjson);

           JSONArray products = mainObj.getJSONArray("products");

           for(int i =0;i<products.length();i++)
           {
               JSONObject childObj= products.getJSONObject(i);
               String name = childObj.getString("title");

               pro.add(new Products(name));
           }

         System.out.println("Size of Arraylist"+pro.size());
           adpt =new Listadpt(getApplication(),pro);
           lstv.setAdapter(adpt);
            //setOnItemClickListener
          lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                  Intent intent = new Intent(FirstPage.this,MainActivity.class);
                  intent.putExtra("data",pro.get(position));
                  startActivity(intent);
              }
          });


       }


       catch (ExecutionException e)
       {
           Log.e("MainActivity :",e.getMessage());
       }
       catch (InterruptedException e)
       {
           Log.e("MainActivity :",e.getMessage());
       }catch (JSONException e)
       {
           Log.e("MainActivity :",e.getMessage());
       }




    }
}
