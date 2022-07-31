package com.jc897407.oldify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class AddItemActivity extends AppCompatActivity {

    private SharedPreferences dataSource;
    private EditText item_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        dataSource = getSharedPreferences("todo_items", MODE_PRIVATE);
        item_name = findViewById(R.id.item_name);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            if (item_name.getText().length() == 0){
                Toast.makeText(this, "No item name given", Toast.LENGTH_SHORT).show();
                return true;
            }

            Set<String> items =
                    dataSource.getStringSet("items", new HashSet<String>());
            assert items != null;
            items.add(item_name.getText().toString());
            dataSource.edit().clear().putStringSet("items", items).apply();

            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}