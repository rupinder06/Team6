package com.example.team6;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView logo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);



        getSupportActionBar().hide();




        logolauncher logolauncher =new logolauncher();

        logolauncher.start();

    }
    private class logolauncher extends Thread{
        public void run()
        {
            try{


                sleep(1000*5);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            Intent intent =new Intent(MainActivity.this,FirstPage.class);
            startActivity(intent);

            MainActivity.this.finish();
        }

    }



}
