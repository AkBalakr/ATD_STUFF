package com.example.tinohacks.audiotextdefinition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(screen2.this, android.R.layout.simple_list_item_1);


//        adapter.add(word + ":" + def);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);

//        ListView Speech = (ListView) findViewById(R.id.listView);
//        adapter.add(sentence);
    }

}

