package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> platforms = new ArrayList<>();
    private String selectedOption;
    private int stars;
    private String country;
    private ArrayList<String> universities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stars = 0;
        CheckBox checkboxIos = findViewById(R.id.checkbox_ios);
        CheckBox checkboxAndroid = findViewById(R.id.checkbox_android);
        CheckBox checkboxWp = findViewById(R.id.checkbox_wp);
        checkboxIos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkboxIos.isChecked()) {
                    // Checkbox 1 is checked, perform the desired action.
                    platforms.add("iOS");
                } else {
                    // Checkbox 1 is unchecked, perform another action if needed.
                    platforms.remove("iOS");
                }
            }
        });
        checkboxAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkboxAndroid.isChecked()) {
                    // Checkbox 1 is checked, perform the desired action.
                    platforms.add("Android");
                } else {
                    // Checkbox 1 is unchecked, perform another action if needed.
                    platforms.remove("Android");
                }
            }
        });
        checkboxWp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkboxWp.isChecked()) {
                    // Checkbox 1 is checked, perform the desired action.
                    platforms.add("Windows Phone");
                } else {
                    // Checkbox 1 is unchecked, perform another action if needed.
                    platforms.remove("Windows Phone");
                }
            }
        });
        RadioGroup radioGroup = findViewById(R.id.radioGroupGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                if (selectedRadioButton != null) {
                    selectedOption = selectedRadioButton.getText().toString();
                }
            }
        });
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                stars = (int)rating;
            }
        });
        Spinner spinner = findViewById(R.id.spinnerCountry);

        // Create an ArrayAdapter with items for the Spinner.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                country = parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle the case when nothing is selected (optional).
            }
        });
        ListView listView = findViewById(R.id.listviewUniversity);

        // Create an ArrayAdapter with items you want to display.
        String[] items = {"PTIT", "NEU", "FTU", "HUST", "VNU"};
        ArrayAdapter<String> adapterUniversity = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        // Set the ArrayAdapter on the ListView.
        listView.setAdapter(adapterUniversity);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                // Toggle item selection (add or remove from the ArrayList).
                if (universities.contains(selectedItem)) {
                    view.setBackgroundColor(Color.WHITE);
                    universities.remove(selectedItem);
                } else {
                    view.setBackgroundColor(Color.LTGRAY);
                    universities.add(selectedItem);
                }
            }
        });
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textPlatform = findViewById(R.id.txt_platformKQ);
                textPlatform.setText("Platform: ");
                TextView textGender = findViewById(R.id.txt_genderKQ);
                textGender.setText("Gender: ");
                TextView textRate = findViewById(R.id.txt_rateKQ);
                textRate.setText("Rate: ");
                TextView textCountry = findViewById(R.id.txt_countryKQ);
                textCountry.setText("Country: ");
                TextView textUniversity = findViewById(R.id.txt_universeKQ);
                textUniversity.setText("Universities: ");
                String pf = textPlatform.getText().toString();
                for (int i = 0; i < platforms.size(); i++){
                    pf += platforms.get(i);
                    if (i < platforms.size() - 1) pf += ", ";
                }
                textPlatform.setText(pf);
                textGender.setText(textGender.getText().toString() + selectedOption);
                textRate.setText(textRate.getText().toString() + Integer.toString(stars));
                textCountry.setText(textCountry.getText().toString() + country);
                String uni = textUniversity.getText().toString();
                for (int i = 0; i < universities.size(); i++){
                    uni += universities.get(i);
                    if (i < universities.size() - 1) uni += ", ";
                }
                textUniversity.setText(uni);
            }
        });
        Button clear = findViewById(R.id.btn_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textPlatform = findViewById(R.id.txt_platformKQ);
                textPlatform.setText("Platform: ");
                TextView textGender = findViewById(R.id.txt_genderKQ);
                textGender.setText("Gender: ");
                TextView textRate = findViewById(R.id.txt_rateKQ);
                textRate.setText("Rate: ");
                TextView textCountry = findViewById(R.id.txt_countryKQ);
                textCountry.setText("Country: ");
                TextView textUniversity = findViewById(R.id.txt_universeKQ);
                textUniversity.setText("Universities: ");
            }
        });
    }
}
