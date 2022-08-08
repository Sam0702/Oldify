package com.jc897407.oldify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ZoomControls;

import org.w3c.dom.Text;

public class ActionPage extends AppCompatActivity {
    TextView calltxt, messagetxt, googletxt, googlemaptxt, medicinetxt;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_page);

        calltxt = findViewById(R.id.calltxt);
        messagetxt = findViewById(R.id.messagetxt);
        googletxt = findViewById(R.id.googletxt);
        googlemaptxt = findViewById(R.id.googlemaptxt);
        medicinetxt = findViewById(R.id.medicinetxt);
        seekBar = findViewById(R.id.seekBar);

        // Increase the text size using SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calltxt.setTextSize(progress);
                messagetxt.setTextSize(progress);
                googletxt.setTextSize(progress);
                googlemaptxt.setTextSize(progress);
                medicinetxt.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
            Intent intent = new Intent(this, Medicines.class);
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