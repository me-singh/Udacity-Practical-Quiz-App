package com.example.kadyan.udacitypracticalquizapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    TextView userName, userEmail, userAbout;
    de.hdodenhof.circleimageview.CircleImageView profilePic;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar()!=null)


        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userAbout = findViewById(R.id.userAbout);
        profilePic = findViewById(R.id.userImage);
        sharedPreferences = getSharedPreferences(MainActivity.PREFERENCES, Context.MODE_PRIVATE);

        Glide.with(this)
                .load(R.drawable.profile_pic_new)
                .into(profilePic);

        userName.setText(sharedPreferences.getString(MainActivity.USER_NAME, ""));
        userEmail.setText(sharedPreferences.getString(MainActivity.EMAIL, ""));
        userAbout.setText(sharedPreferences.getString(MainActivity.ABOUT, ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
