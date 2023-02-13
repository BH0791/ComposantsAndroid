package com.example.composantsandroid;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBoxCheckAll;
    CheckBox checkBoxCcpp;
    CheckBox checkBoxGroovy;
    CheckBox checkBoxJava;
    Button btnAfficher;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxCheckAll = findViewById(R.id.checkBox_checkAll);
        checkBoxCcpp = findViewById(R.id.checkBox_ccpp);
        checkBoxGroovy = findViewById(R.id.checkBox_groovy);
        checkBoxJava = findViewById(R.id.checkBox_java);
        btnAfficher = findViewById(R.id.button_btnAfficher);

        btnAfficher.setOnClickListener(v -> {
            String message = null;
            if(this.checkBoxCcpp.isChecked()) {
                message =  this.checkBoxCcpp.getText().toString();
            }
            if(this.checkBoxGroovy.isChecked()) {
                if(message== null)  {
                    message =  this.checkBoxGroovy.getText().toString();
                } else {
                    message += ", " + this.checkBoxGroovy.getText().toString();
                }
            }
            if(this.checkBoxJava.isChecked()) {
                if(message== null)  {
                    message =  this.checkBoxJava.getText().toString();
                } else {
                    message += ", " + this.checkBoxJava.getText().toString();
                }
            }
            message = message == null? "Pas de sélection": "Votre choix: " + message;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        });

        checkBoxCheckAll.setOnCheckedChangeListener((bt, choix) -> {
            this.checkBoxGroovy.setChecked(choix);
            this.checkBoxCcpp.setChecked(choix);
            this.checkBoxJava.setChecked(choix);
        });

    }

}