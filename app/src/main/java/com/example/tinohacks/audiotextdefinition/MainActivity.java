package com.example.tinohacks.audiotextdefinition;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> myArray = new ArrayList<String>();
    private final int SPEECH_RECOGNITION_CODE = 1;
    private TextView txtOutput;
    Button record;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        record = (Button) findViewById(R.id.rec);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSpeechToText();

            }
        });
        myArray = new ArrayList<String>();
    }

    private void startSpeechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speak something...");
        try {
            startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Speech recognition is not supported in this device.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SPEECH_RECOGNITION_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String text = result.get(0);

                    StringTokenizer st = new StringTokenizer(text);


                    while (st.hasMoreElements()) {
                        myArray.add(st.nextToken());
                    }


                }
                break;

            }



        }
        Intent inter = new Intent(getApplication(), screen2.class);
        startActivity(inter);
    }

}
