package com.odepe.samprotikee;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager pager;
    PagerTabStrip tab_strp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ma_pager_adapter mapager=new ma_pager_adapter(getSupportFragmentManager());
        pager=(ViewPager)findViewById(R.id.pager);


        pager.setAdapter(mapager);
        tab_strp=(PagerTabStrip)findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.RED);
        //tab_strp.setTextSize(14,14);
        tab_strp.setGravity(Gravity.LEFT);
        tab_strp.setTabIndicatorColor(Color.RED);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent login = new Intent(MainActivity.this, About.class);
            startActivity(login);
            return true;
        } else if(id == R.id.action_refresh) {
            Intent login = new Intent(MainActivity.this, MainActivity.class);
            startActivity(login);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        /*if (id == R.id.nav_international) {
            //Create an alertdialog
            final AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(MainActivity.this);
            Checkbuilder.setTitle("দুঃখিত!");
            Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
            //Builder Retry Button
            Checkbuilder.setNegativeButton("ঠিক আছে", null);
            AlertDialog alert=Checkbuilder.create();
            alert.show();


        }else if (id == R.id.nav_finance) {
            //Create an alertdialog
            final AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(MainActivity.this);
            Checkbuilder.setTitle("দুঃখিত!");
            Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
            //Builder Retry Button
            Checkbuilder.setNegativeButton("ঠিক আছে", null);
            AlertDialog alert=Checkbuilder.create();
            alert.show();
        }else if (id == R.id.nav_sports) {
            //Create an alertdialog
            final AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(MainActivity.this);
            Checkbuilder.setTitle("দুঃখিত!");
            Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
            //Builder Retry Button
            Checkbuilder.setNegativeButton("ঠিক আছে", null);
            AlertDialog alert=Checkbuilder.create();
            alert.show();

        }else if (id == R.id.nav_science) {
            //Create an alertdialog
            final AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(MainActivity.this);
            Checkbuilder.setTitle("দুঃখিত!");
            Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
            //Builder Retry Button
            Checkbuilder.setNegativeButton("ঠিক আছে", null);
            AlertDialog alert=Checkbuilder.create();
            alert.show();

        }else if (id == R.id.nav_relax) {
            //Create an alertdialog
            final AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(MainActivity.this);
            Checkbuilder.setTitle("দুঃখিত!");
            Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
            //Builder Retry Button
            Checkbuilder.setNegativeButton("ঠিক আছে", null);
            AlertDialog alert=Checkbuilder.create();
            alert.show();

        }else if (id == R.id.nav_regular) {

            //Create an alertdialog
            final AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(MainActivity.this);
            Checkbuilder.setTitle("দুঃখিত!");
            Checkbuilder.setMessage("এই অপশনটির কাজ বর্তমান চলমান রয়েছে.. ");
            //Builder Retry Button
            Checkbuilder.setNegativeButton("ঠিক আছে", null);
            AlertDialog alert=Checkbuilder.create();
            alert.show();
        }else */ if (id == R.id.nav_contact) {

            Intent login = new Intent(MainActivity.this, contact.class);
            startActivity(login);
            // Handle the camera action
        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out Samprotikee News app at: https://play.google.com/store/apps/details?id=com.odepe.samprotikee");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
