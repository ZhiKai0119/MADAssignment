package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchViewFromList extends AppCompatActivity {

    ListView listView;
    SearchView searchView;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        listView = (ListView) findViewById(R.id.search_list);
        searchView =(SearchView) findViewById(R.id.searching);

        for(int i=0; i<=100; i++){
            stringArrayList.add("Item" + i);
        }

        adapter = new ArrayAdapter<>(SearchViewFromList.this, android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}