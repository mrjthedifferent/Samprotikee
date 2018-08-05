package com.odepe.samprotikee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button fblink, button, button2, button3;


        fblink = (Button)findViewById(R.id.fblink);
        fblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fblink = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/samprotikee"));
                startActivity(fblink);
            }
        });

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com/samprotikee"));
                startActivity(button);
            }
        });


        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://plus.google.com/109013467704574081776"));
                startActivity(button2);
            }
        });

        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.odepe.com"));
                startActivity(button3);
            }
        });



    }
}
