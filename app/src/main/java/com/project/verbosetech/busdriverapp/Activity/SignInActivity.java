package com.project.verbosetech.busdriverapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.project.verbosetech.busdriverapp.Other.PrefManager;
import com.project.verbosetech.busdriverapp.R;

/**
 * Created by this pc on 22-05-17.
 */

public class SignInActivity extends AppCompatActivity {
    Spinner spinner;
    ImageButton imageButton;
    PrefManager prefManager;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_sign_in);
        prefManager = new PrefManager(getApplicationContext());
        name = (EditText) findViewById(R.id.editname);
        spinner = (Spinner) findViewById(R.id.bus_number);
        imageButton = (ImageButton) findViewById(R.id.sign_in);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPadding(0, spinner.getPaddingTop(), spinner.getPaddingRight(), spinner.getPaddingBottom());
        spinner.setAdapter(adapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefManager.setName("Mahesh Prajapati");
                prefManager.setBusNo(spinner.getSelectedItem().toString());
                prefManager.setFilter(null);
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
