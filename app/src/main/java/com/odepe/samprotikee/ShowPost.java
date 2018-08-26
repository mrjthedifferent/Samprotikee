package com.odepe.samprotikee;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

    TextView title, details, title2, subtitle;
    WebView content;
    ImageView post_img, icon;
    Button comment;
    String share = "0";
    CardView nextnews;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        title = (TextView) findViewById(R.id.title);
        title2 = (TextView) findViewById(R.id.title2);
        subtitle = (TextView) findViewById(R.id.subtitle);
        details = (TextView) findViewById(R.id.details);
        content = (WebView) findViewById(R.id.content_view);
        post_img = (ImageView) findViewById(R.id.post_img);
        icon = (ImageView) findViewById(R.id.icon_n);
        comment = (Button) findViewById(R.id.comments);
        nextnews = (CardView) findViewById(R.id.nextnews);


        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an alertdialog
                final AlertDialog.Builder Checkbuilder = new AlertDialog.Builder(ShowPost.this);
                Checkbuilder.setTitle("দুঃখিত!");
                Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
                //Builder Retry Button
                Checkbuilder.setNegativeButton("ঠিক আছে", null);
                AlertDialog alert = Checkbuilder.create();
                alert.show();
            }
        });

        Intent i = getIntent();
        @SuppressLint({"NewApi", "LocalSuppress"}) final int position = Objects.requireNonNull(i.getExtras()).getInt("itemPosition");

        String get_tab = i.getStringExtra("get_tab");

        if (get_tab.equals("tab1")) {

            title.setText(tab1.mListPost.get(position).getTitle().getRendered());
            share = tab4.mListPost.get(position).getTitle().getRendered();
            //details.setText( MainActivity.mListPost.get(position).getModified());

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(), "fonts/SolaimanLipi.ttf");
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
            System.out.println("s2 " + s2);
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

            String head = "<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab1.mListPost.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8", "UTF-8");

            //next news coding
            title2.setText(tab1.mListPost.get(position + 1).getTitle().getRendered());
            String date2 = tab1.mListPost.get(position + 1).getModified();
            Date d2 = null;
            try {
                d2 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s22 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s22 " + s22);
            subtitle.setText(s22);
            String link2 = tab1.mListPost.get(position + 1).getBetterFeaturedImage().getSourceUrl();
            Glide.with(this)
                    .load(link2)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(icon);

            nextnews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(ShowPost.this, ShowPost.class);
                    detail.putExtra("itemPosition", position + 1);
                    detail.putExtra("get_tab", "tab1");
                    startActivity(detail);
                }
            });

        } else if (get_tab.equals("tab2")) {

            title.setText(tab2.mListPost2.get(position).getTitle().getRendered());
            //details.setText( MainActivity.mListPost.get(position).getModified());

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(), "fonts/SolaimanLipi.ttf");
            title.setTypeface(font);

            //converting date to readable format
            String date = tab2.mListPost2.get(position).getModified();
            Date d = null;
            try {
                d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s2 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s2 " + s2);
            details.setText(s2);

            String link = tab2.mListPost2.get(position).getBetterFeaturedImage().getSourceUrl();

            Glide.with(this)
                    .load(link)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(post_img);

            String head = "<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab2.mListPost2.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8", "UTF-8");

            //next news coding
            title2.setText(tab2.mListPost2.get(position + 1).getTitle().getRendered());
            String date2 = tab2.mListPost2.get(position + 1).getModified();
            Date d2 = null;
            try {
                d2 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s22 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s22 " + s22);
            subtitle.setText(s22);
            String link2 = tab2.mListPost2.get(position + 1).getBetterFeaturedImage().getSourceUrl();
            Glide.with(this)
                    .load(link2)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(icon);

            nextnews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(ShowPost.this, ShowPost.class);
                    detail.putExtra("itemPosition", position + 1);
                    detail.putExtra("get_tab", "tab2");
                    startActivity(detail);
                }
            });

        } else if (get_tab.equals("tab3")) {
            title.setText(tab3.mListPost.get(position).getTitle().getRendered());
            //details.setText( MainActivity.mListPost.get(position).getModified());

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(), "fonts/SolaimanLipi.ttf");
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
            System.out.println("s2 " + s2);
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

            String head = "<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab3.mListPost.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8", "UTF-8");

            //next news coding
            title2.setText(tab3.mListPost.get(position + 1).getTitle().getRendered());
            String date2 = tab3.mListPost.get(position + 1).getModified();
            Date d2 = null;
            try {
                d2 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s22 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s22 " + s22);
            subtitle.setText(s22);
            String link2 = tab3.mListPost.get(position + 1).getBetterFeaturedImage().getSourceUrl();
            Glide.with(this)
                    .load(link2)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(icon);

            nextnews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(ShowPost.this, ShowPost.class);
                    detail.putExtra("itemPosition", position + 1);
                    detail.putExtra("get_tab", "tab3");
                    startActivity(detail);
                }
            });

        } else if (get_tab.equals("tab4")) {
            title.setText(tab4.mListPost.get(position).getTitle().getRendered());
            //details.setText( MainActivity.mListPost.get(position).getModified());
            share = tab4.mListPost.get(position).getTitle().getRendered();

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(), "fonts/SolaimanLipi.ttf");
            title.setTypeface(font);

            //converting date to readable format
            String date = tab4.mListPost.get(position).getModified();
            Date d = null;
            try {
                d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s2 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s2 " + s2);
            details.setText(s2);

            String link = tab4.mListPost.get(position).getBetterFeaturedImage().getSourceUrl();

            Glide.with(this)
                    .load(link)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(post_img);

            String head = "<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab4.mListPost.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8", "UTF-8");

            //next news coding
            title2.setText(tab4.mListPost.get(position + 1).getTitle().getRendered());
            String date2 = tab4.mListPost.get(position + 1).getModified();
            Date d2 = null;
            try {
                d2 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s22 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s22 " + s22);
            subtitle.setText(s22);
            String link2 = tab4.mListPost.get(position + 1).getBetterFeaturedImage().getSourceUrl();
            Glide.with(this)
                    .load(link2)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(icon);

            nextnews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(ShowPost.this, ShowPost.class);
                    detail.putExtra("itemPosition", position + 1);
                    detail.putExtra("get_tab", "tab4");
                    startActivity(detail);
                }
            });

        } else {

            title.setText(tab1.mListPost.get(position).getTitle().getRendered());
            //details.setText( MainActivity.mListPost.get(position).getModified());

            Typeface font = Typeface.createFromAsset(ShowPost.this.getAssets(), "fonts/SolaimanLipi.ttf");
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
            System.out.println("s2 " + s2);
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

            String head = "<html> <head> <style> img { display: none; } </style></head> <body style=\"text-align:justify;color:black;\">";
            String data = tab1.mListPost.get(position).getContent().getRendered();
            String footer = "</body></html>";
            String total = head + data + footer;
            content.loadData(total, "text/html; charset=utf-8", "UTF-8");

            //next news coding
            title2.setText(tab1.mListPost.get(position + 1).getTitle().getRendered());
            String date2 = tab1.mListPost.get(position + 1).getModified();
            Date d2 = null;
            try {
                d2 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") String s22 = (new SimpleDateFormat("dd MMMM yyyy hh:mm a")).format(d);
            System.out.println("s22 " + s22);
            subtitle.setText(s22);
            String link2 = tab1.mListPost.get(position + 1).getBetterFeaturedImage().getSourceUrl();
            Glide.with(this)
                    .load(link2)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.on_loading)
                            .centerCrop()
                            .dontAnimate()
                            .dontTransform())
                    .into(icon);

            nextnews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(ShowPost.this, ShowPost.class);
                    detail.putExtra("itemPosition", position + 1);
                    detail.putExtra("get_tab", "tab1");
                    startActivity(detail);
                }
            });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.showpost, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            Intent i = getIntent();
            @SuppressLint({"NewApi", "LocalSuppress"}) int position = Objects.requireNonNull(i.getExtras()).getInt("itemPosition");
            String get_tab = i.getStringExtra("get_tab");
            if (get_tab.equals("tab1")) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "সংবাদটি সাংম্প্রতিকী অ্যান্ড্রয়েড অ্যাপ থেকে শেয়ার করা হয়েছে। \n" + tab1.mListPost.get(position).getGuid().getRendered());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else if (get_tab.equals("tab2")) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "সংবাদটি সাংম্প্রতিকী অ্যান্ড্রয়েড অ্যাপ থেকে শেয়ার করা হয়েছে। \n" + tab2.mListPost2.get(position).getGuid().getRendered());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else if (get_tab.equals("tab3")) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "সংবাদটি সাংম্প্রতিকী অ্যান্ড্রয়েড অ্যাপ থেকে শেয়ার করা হয়েছে। \n" + tab3.mListPost.get(position).getGuid().getRendered());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else if (get_tab.equals("tab4")) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "সংবাদটি সাংম্প্রতিকী অ্যান্ড্রয়েড অ্যাপ থেকে শেয়ার করা হয়েছে। \n" + tab4.mListPost.get(position).getGuid().getRendered());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "সংবাদটি সাংম্প্রতিকী অ্যান্ড্রয়েড অ্যাপ থেকে শেয়ার করা হয়েছে। \n" + tab1.mListPost.get(position).getGuid().getRendered());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
