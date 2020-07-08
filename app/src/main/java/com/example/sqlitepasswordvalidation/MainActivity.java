package com.example.sqlitepasswordvalidation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    TextView tvNameError, tvEmailError, tvPasswordError;
    CardView cardOne, cardTwo, cardThree, cardFour, btnRegister;
    private boolean isAtleast8 = false, hasUpperCase = false, hasNumber = false, hasSymbol = false, isRegistrationClickable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvNameError = findViewById(R.id.tvNameError);
        tvEmailError = findViewById(R.id.tvEmailError);
        tvPasswordError = findViewById(R.id.tvPasswordError);
        cardOne = findViewById(R.id.cardOne);
        cardTwo = findViewById(R.id.cardTwo);
        cardThree = findViewById(R.id.cardThree);
        cardFour = findViewById(R.id.cardFour);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString(),
                        email = etEmail.getText().toString(),
                        password = etPassword.getText().toString();
                if (name.length() > 0 && email.length() > 0 && password.length() > 0){
                    if (isRegistrationClickable){
                        Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (name.length() == 0){
                        tvNameError.setVisibility(View.VISIBLE);
                    }
                    if (email.length() == 0){
                        tvEmailError.setVisibility(View.VISIBLE);
                    }
                    if (password.length() == 0){
                        tvPasswordError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        inputChange();
    }

    private void checkEmptyField(String name, String email, String password){
        if (name.length() > 0 && tvNameError.getVisibility() == View.VISIBLE){
            tvNameError.setVisibility(View.GONE);
        }
        if (email.length() > 0 && tvEmailError.getVisibility() == View.VISIBLE){
            tvEmailError.setVisibility(View.GONE);
        }
        if (password.length() > 0 && tvPasswordError.getVisibility() == View.VISIBLE){
            tvPasswordError.setVisibility(View.GONE);
        }
    }

    @SuppressLint("ResourceType")
    private void passwordCheck(){
        String name = etName.getText().toString(),
                email = etEmail.getText().toString(),
                password = etPassword.getText().toString();

        checkEmptyField(name, email, password);

        // for 8 characters
        if (password.length() >= 8){
            isAtleast8 = true;
            cardOne.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        }else {
            isAtleast8 = false;
            cardOne.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }

        // for uppercase
        if (password.matches("(.*[A-Z].*)")) {
            hasUpperCase = true;
            cardTwo.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            isAtleast8 = false;
            cardTwo.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }

        // for number
        if (password.matches("^(?=.*[_.()]).*$")) {
            hasUpperCase = true;
            cardThree.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            isAtleast8 = false;
            cardThree.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }

        // for symbol
        if (password.matches("^(?=.*[_.()]).*$")) {
            hasUpperCase = true;
            cardFour.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            isAtleast8 = false;
            cardFour.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }

        checkAllData(email);
    }

    // if all fields are filled properly the btn color will change
    @SuppressLint("ResourceType")
    private void checkAllData(String email) {
        if (isAtleast8 && hasUpperCase && hasNumber && hasSymbol && email.length() > 0) {
            isRegistrationClickable = true;
            btnRegister.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            isRegistrationClickable = false;
            btnRegister.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
    }

    private void inputChange(){
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}