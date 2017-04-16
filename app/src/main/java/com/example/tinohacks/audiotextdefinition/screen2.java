package com.example.tinohacks.audiotextdefinition;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class screen2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(screen2.this, android.R.layout.simple_list_item_1);

//      adapter.add(word + ":" + def);
        ListView listView = (ListView) findViewById(R.id.listView);



//        ListView Speech = (ListView) findViewById(R.id.listView);
//        adapter.add(sentence);
        // int size = adapter.getCount();

        for(int i = 0; i < MainActivity.myArray.size(); i ++){
            adapter.add(MainActivity.myArray.get(i) + " "+ "Link to Definition:www.dictionary.com/browse/" + MainActivity.myArray.get(i));
        }
    }

}


