package com.example.team6;

import android.os.AsyncTask;

import java.util.BitSet;

public class Syncdata extends AsyncTask<String, Void, String> {


   protected void onpreExecute()
   {
       super.onPreExecute();
   }
   protected void onPostExcute(String s)
   {
       super.onPostExecute(s);

       System.out.println(s);
   }



    @Override
    protected String doInBackground(String... strings) {



        String jurl = strings[0];

        Httphandler hp = new Httphandler();

        String json = hp.makeService(jurl);

        System.out.println("This is from Syncdata :"+json);

        return json;
    }


}
