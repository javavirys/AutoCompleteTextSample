package com.example.autocompleteedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TEST";
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView edit = findViewById(R.id.autoCompleteTextView);
        edit.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES0));
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = edit.getText().toString();
                if(text.length() > 3){
                    // Грузим случайным образом данные в список.
                    Random rnd = new Random();
                    int i = Math.abs(rnd.nextInt() % 3);
                    Log.d(TAG, "onTextChanged: "+ i);
                    switch (i) {
                        case 0:
                            edit.setAdapter(new ArrayAdapter<>(MainActivity.this,
                                    android.R.layout.simple_dropdown_item_1line, COUNTRIES0));
                        break;
                        case 1:
                            edit.setAdapter(new ArrayAdapter<>(MainActivity.this,
                                    android.R.layout.simple_dropdown_item_1line, COUNTRIES1));
                            break;
                        case 2:
                            edit.setAdapter(new ArrayAdapter<>(MainActivity.this,
                                    android.R.layout.simple_dropdown_item_1line, COUNTRIES2));
                            break;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private static final String[] COUNTRIES0 = new String[] {
            "Belgium","Belarus", "France", "Italy", "Germany", "Spain"
    };

    private static final String[] COUNTRIES1 = new String[] {
            "Belgium1", "France1", "Italy1", "Germany1", "Spain1"
    };

    private static final String[] COUNTRIES2 = new String[] {
            "Belgium2", "France2", "Italy2", "Germany2", "Spain2"
    };

}
