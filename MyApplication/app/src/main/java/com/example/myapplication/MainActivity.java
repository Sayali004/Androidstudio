package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etAge;
    RadioGroup rgGender;
    Button btnRegister, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAge = findViewById(R.id.etAge);
        rgGender = findViewById(R.id.rgGender);
        btnRegister = findViewById(R.id.btnRegister);
        btnClear = findViewById(R.id.btnClear);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String age = etAge.getText().toString().trim();

            int selectedGenderId = rgGender.getCheckedRadioButtonId();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()
                    || age.isEmpty() || selectedGenderId == -1) {

                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();

            } else {

                RadioButton rbGender = findViewById(selectedGenderId);
                String gender = rbGender.getText().toString();

                Toast.makeText(
                        this,
                        "Registered Successfully\n" +
                                "Name: " + name +
                                "\nEmail: " + email +
                                "\nAge: " + age +
                                "\nGender: " + gender,
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        // Clear button
        btnClear.setOnClickListener(v -> {
            etName.setText("");
            etEmail.setText("");
            etPassword.setText("");
            etAge.setText("");
            rgGender.clearCheck();
        });
    }
}
