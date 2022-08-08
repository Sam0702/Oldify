package com.jc897407.oldify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Signin without OTP
        Button signup = findViewById(R.id.signup);
        signup.setOnClickListener(view -> {
            Intent intent = new Intent(this, signIn.class);
            startActivity(intent);
        });
        //Signin With OTP
        Button signup2 = findViewById(R.id.signup2);
        signup2.setOnClickListener(view -> {
            Intent intent = new Intent(this, signIn_Security.class);
            startActivity(intent);
        });

        Button age_fn = (Button) findViewById(R.id.age_button);
        age_fn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age_function();
            }
        });
    }

    private void age_function() {

        Button signup = findViewById(R.id.signup);
        Button signup2 = findViewById(R.id.signup2);
        Button age_button = findViewById(R.id.age_button);

        EditText age = findViewById(R.id.age);
        double amount = Double.parseDouble(age.getText().toString());

        if (amount >= 70) {
            signup.setVisibility(View.VISIBLE);
        }

        else {
            signup.setVisibility(View.VISIBLE);
            signup2.setVisibility(View.VISIBLE);
        }

        age_button.setVisibility(View.INVISIBLE);
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