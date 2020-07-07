package com.example.sqlitepasswordvalidation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
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
}