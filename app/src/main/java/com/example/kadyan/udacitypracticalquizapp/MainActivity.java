package com.example.kadyan.udacitypracticalquizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PREFERENCES = "appPrefs";

    public static final String USER_NAME = "userName";
    public static final String EMAIL = "userEmail";
    public static final String ABOUT = "userAbout";

    EditText userName, email, about;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        sharedpreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);

        userName = findViewById(R.id.editTextUserName);
        email = findViewById(R.id.edittextEmail);
        about = findViewById(R.id.editTextAbout);
        CardView nextButton = findViewById(R.id.button_next);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(USER_NAME))
                userName.setText(savedInstanceState.getString(USER_NAME));
            if (savedInstanceState.containsKey(EMAIL))
                email.setText(savedInstanceState.getString(EMAIL));
            if (savedInstanceState.containsKey(ABOUT))
                about.setText(savedInstanceState.getString(ABOUT));
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(USER_NAME, userName.getText().toString());
                editor.putString(EMAIL, email.getText().toString());
                editor.putString(ABOUT, about.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(USER_NAME, userName.getText().toString());
        outState.putString(EMAIL, email.getText().toString());
        outState.putString(ABOUT, about.getText().toString());
    }

}
