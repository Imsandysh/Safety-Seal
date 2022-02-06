package com.example.safety_seal;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    public int pillNum = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        final ImageView imgFish [] = new ImageView[5];
        imgFish[0] = (ImageView) findViewById(R.id.imgFish1);
        imgFish[1] = (ImageView) findViewById(R.id.imgFish2);
        imgFish[2] = (ImageView) findViewById(R.id.imgFish3);
        imgFish[3] = (ImageView) findViewById(R.id.imgFish4);
        imgFish[4] = (ImageView) findViewById(R.id.imgFish5);
        int count = 1;
        for(ImageView img : imgFish){
           if(count <= pillNum){
               img.setVisibility(View.VISIBLE);
           }else{
               img.setVisibility(View.INVISIBLE);
           }
            count++;
        }

        //final int imageResource1 = getResources().getIdentifier("@drawable/black_seal_look_left",null,this.getPackageName());
        //final int imageResource2 = getResources().getIdentifier("@drawable/black_seal_look_right",null,this.getPackageName());

        final ImageView imgSealLook = (ImageView) findViewById(R.id.imgSealLook);
        runAnim(imgSealLook);
        Button btnTakePill = (Button) findViewById(R.id.btnTakePill);
        btnTakePill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pillNum --;
                int count = 1;
                for(ImageView img : imgFish){
                    if(count <= pillNum){
                        img.setVisibility(View.VISIBLE);
                    }else{
                        img.setVisibility(View.INVISIBLE);
                    }
                    count++;
                }

            }
        });


    }
    public void runAnim(ImageView a) {
        Drawable drw = getResources().getDrawable(R.drawable.animation);
        a.setImageDrawable(drw);
        AnimationDrawable anim = (AnimationDrawable) a.getDrawable();
        anim.start();
    }
}
