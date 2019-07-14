package com.example.team6;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView logo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        logo2 = findViewById(R.id.imageView);

        getSupportActionBar().hide();
        Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        ani.setDuration(3000);



        logolauncher logolauncher =new logolauncher();
        logo2.setAnimation(ani);
        logolauncher.start();

    }
    private class logolauncher extends Thread{
        public void run()
        {
            try{


                sleep(1000*4);
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