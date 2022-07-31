package com.jc897407.oldify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class Medicines extends AppCompatActivity {

    private ListView todoList;
    private ArrayAdapter<String> adapter;
    private SharedPreferences dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines);
        dataSource = getSharedPreferences("todo_items", MODE_PRIVATE);
        todoList = findViewById(R.id.todoList);
        adapter = new ArrayAdapter<>(this, R.layout.items);
        todoList.setAdapter(adapter);
        adapter.addAll("buy milk", "wash car", "call mum");

        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView itemView = (TextView) view;
                adapter.remove(itemView.getText().toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        Set<String> newItems = dataSource.getStringSet("items", new HashSet<String>());
        assert newItems != null;
        adapter.addAll(newItems);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Set<String> items = new HashSet<String>();
        for (int i = 0; i < adapter.getCount(); i++){
            items.add(adapter.getItem(i));
        }
        dataSource.edit().clear().putStringSet("items", items).apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_item){
            Intent intent = new Intent(this, AddItemActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}