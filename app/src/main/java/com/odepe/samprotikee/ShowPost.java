package com.odepe.samprotikee;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ShowPost extends AppCompatActivity {

    TextView title,details;
    WebView content;
    ImageView post_img;
    Button comment;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        title = (TextView) findViewById(R.id.title);
        details = (TextView) findViewById(R.id.details);
        content = (WebView)findViewById(R.id.content_view);
        post_img = (ImageView)findViewById(R.id.post_img);
        comment = (Button)findViewById(R.id.comment);


        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an alertdialog
                final AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(ShowPost.this);
                Checkbuilder.setTitle("দুঃখিত!");
                Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
                //Builder Retry Button
                Checkbuilder.setNegativeButton("ঠিক আছে", null);
                AlertDialog alert=Checkbuilder.create();
                alert.show();
            }
        });


        Intent i = getIntent();
        @SuppressLint({"NewApi", "LocalSuppress"}) int position = Objects.requireNonNull(i.getExtras()).getInt("itemPosition");

        String get_tab = i.getStringExtra("get_tab");

        if(get_tab.equals("tab1"))
        {
            title.setText( tab1.mListPost.get(position).getTitle().getRendered());
            //details.setText( MainActivity.mListPost.get(position).getModified());

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(),"fonts/SolaimanLipi.ttf");
            title.setTypeface(font);

            //converting date to readable format
            String date = tab1.mListPost.get(position).getModified();
            Date d = null;
            try {
                d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s2 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s2 "+s2);
            details.setText(s2);

            String link = tab1.mListPost.get(position).getBetterFeaturedImage().getSourceUrl();

            Glide.with(this)
                    .load(link)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(post_img);

            String head ="<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab1.mListPost.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8","UTF-8");

        }else if(get_tab.equals("tab2")){

            title.setText( tab2.mListPost.get(position).getTitle().getRendered());
            //details.setText( MainActivity.mListPost.get(position).getModified());

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(),"fonts/SolaimanLipi.ttf");
            title.setTypeface(font);

            //converting date to readable format
            String date = tab2.mListPost.get(position).getModified();
            Date d = null;
            try {
                d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s2 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s2 "+s2);
            details.setText(s2);

            String link = tab2.mListPost.get(position).getBetterFeaturedImage().getSourceUrl();

            Glide.with(this)
                    .load(link)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(post_img);

            String head ="<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab2.mListPost.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8","UTF-8");

        }else if (get_tab.equals("tab3")) {
            title.setText( tab3.mListPost.get(position).getTitle().getRendered());
            //details.setText( MainActivity.mListPost.get(position).getModified());

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(),"fonts/SolaimanLipi.ttf");
            title.setTypeface(font);

            //converting date to readable format
            String date = tab3.mListPost.get(position).getModified();
            Date d = null;
            try {
                d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s2 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s2 "+s2);
            details.setText(s2);

            String link = tab3.mListPost.get(position).getBetterFeaturedImage().getSourceUrl();

            Glide.with(this)
                    .load(link)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(post_img);

            String head ="<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab2.mListPost.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8","UTF-8");
        }else{

        }


        //old Version support
        /*
        Intent i = getIntent();
        int position = i.getExtras().getInt("itemPosition");

        title.setText( MainActivity.mListPost.get(position).getTitle().getRendered());
        //details.setText( MainActivity.mListPost.get(position).getModified());

        Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(),"fonts/SolaimanLipi.ttf");
        title.setTypeface(font);

        //converting date to readable format
        String date = MainActivity.mListPost.get(position).getModified();
        Date d = null;
        try {
            d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s2 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s2 "+s2);
        details.setText(s2);
        */
    }
}
