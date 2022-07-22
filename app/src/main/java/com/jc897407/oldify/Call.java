package com.jc897407.oldify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

public class Call extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        ImageView dial_in_icon = findViewById(R.id.dial_in_icon);
        dial_in_icon.setOnClickListener(view -> {
            Intent intent = new Intent(this, Dial_in.class);
            startActivity(intent);
        });

        ImageView emergency_icon = findViewById(R.id.emergency_icon);
        emergency_icon.setOnClickListener(view -> {
            Intent intent = new Intent(this, Emergency.class);
            startActivity(intent);
        });

        ImageView favourite_contact_list = findViewById(R.id.favourite_contact_list);
        favourite_contact_list.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        ImageView contact_list = findViewById(R.id.contact_list);
        contact_list.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}