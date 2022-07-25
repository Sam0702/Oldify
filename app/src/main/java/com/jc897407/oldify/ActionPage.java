package com.jc897407.oldify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ActionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_page);
        ImageView call = findViewById(R.id.call);
        call.setOnClickListener(view -> {
            Intent intent = new Intent(this, Call.class);
            startActivity(intent);
        });

        ImageView message = findViewById(R.id.message);
        message.setOnClickListener(view -> {
            Intent intent = new Intent(this, SMS.class);
            startActivity(intent);
        });

        ImageView google = findViewById(R.id.google);
        google.setOnClickListener(view -> {
            Intent intent = new Intent(this, Google_page.class);
            startActivity(intent);
        });

        ImageView google_maps = findViewById(R.id.google_maps);
        google_maps.setOnClickListener(view -> {
            Intent intent = new Intent(this, Google_maps.class);
            startActivity(intent);
        });

        ImageView medicines = findViewById(R.id.medicines);
        medicines.setOnClickListener(view -> {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        else if (item.getItemId() == R.id.setting){
            Intent intent = new Intent(this, Setting.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}