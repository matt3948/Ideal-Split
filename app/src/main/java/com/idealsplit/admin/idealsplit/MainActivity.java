package com.idealsplit.admin.idealsplit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.text.TextWatcher;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static RadioGroup radioGroup_gender, radioGroup_course;
    private static RadioButton radioButton_gender, radioButton_course;
    private static Button button_splits;
    private static boolean isNull;

    Spinner spinner_ageGroups;
    ArrayAdapter<CharSequence> adapter_ageGroups;

    Spinner spinner_events;
    ArrayAdapter<CharSequence> adapter_events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListenerButton();

        spinner_ageGroups = (Spinner) findViewById(R.id.spinner_age);
        adapter_ageGroups = ArrayAdapter.createFromResource(this, R.array.age_groups
                , android.R.layout.simple_spinner_item);
        adapter_ageGroups.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_ageGroups.setAdapter(adapter_ageGroups);


        spinner_ageGroups.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)
                        + "selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_events = (Spinner) findViewById(R.id.spinner_events);
        adapter_events = ArrayAdapter.createFromResource(this, R.array.events
                , android.R.layout.simple_spinner_item);
        adapter_events.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_events.setAdapter(adapter_events);
        spinner_events.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                     @Override
                                                     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                         Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)
                                                                 + "selected", Toast.LENGTH_LONG).show();
                                                     }

                                                     @Override
                                                     public void onNothingSelected(AdapterView<?> parent) {

                                                     }
                                                 }

        );
    }

    public void onClickListenerButton() {

        button_splits = (Button) findViewById(R.id.button_splits);
        radioGroup_course = (RadioGroup) findViewById(R.id.radioGroup_course);
        radioGroup_gender = (RadioGroup) findViewById(R.id.radioGroup_gender);

            button_splits.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (radioGroup_course.getCheckedRadioButtonId() == -1 ||
                                    radioGroup_gender.getCheckedRadioButtonId() == -1) {
                                //throw error
                            } else {
                                Intent resultIntent = new Intent(MainActivity.this, ResultsActivity.class);
                                startActivity(resultIntent);
                            }
                        }
                    }
            );
    }
}

