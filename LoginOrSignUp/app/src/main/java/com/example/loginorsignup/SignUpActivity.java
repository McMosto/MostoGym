package com.example.loginorsignup;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, nicknameEditText, emailEditText, passwordEditText;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dbHelper = new DatabaseHelper(this);

        firstNameEditText = findViewById(R.id.editTextFirstName);
        lastNameEditText = findViewById(R.id.editTextLastName);
        nicknameEditText = findViewById(R.id.editTextNickname);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);

        Button signUpButton = findViewById(R.id.buttonSignUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    // Inside the signUp() method in SignUpActivity.java
    private void signUp() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String nickname = nicknameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (isValidSignUpData(firstName, lastName, nickname, email, password)) {
            // Sign up successful, navigate to WelcomeActivity
            saveUserData(firstName, lastName, nickname, email, password);
            Intent welcomeIntent = new Intent(SignUpActivity.this, WelcomeActivity.class);
            startActivity(welcomeIntent);
            finish(); // Optional: finish the SignUpActivity to prevent going back
        } else {
            // Show error message
            Toast.makeText(this, "Invalid sign-up data", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveUserData(String firstName, String lastName, String nickname, String email, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_FIRST_NAME, firstName);
        values.put(DatabaseHelper.COLUMN_LAST_NAME, lastName);
        values.put(DatabaseHelper.COLUMN_NICKNAME, nickname);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);

        long newRowId = db.insert(DatabaseHelper.TABLE_USERS, null, values);

        // You can check newRowId to confirm if the insertion was successful

        db.close();
    }


    // Add more sophisticated validation methods as needed
    private boolean isValidSignUpData(String firstName, String lastName, String nickname, String email, String password) {
        // Replace this with your own validation logic
        return !firstName.isEmpty() && !lastName.isEmpty() && !nickname.isEmpty()
                && isValidEmail(email) && isValidPassword(password);
    }

    private boolean isValidEmail(String email) {
        // Replace this with your own email validation logic
        return email.contains("@");
    }

    private boolean isValidPassword(String password) {
        // Replace this with your own password validation logic
        return password.length() >= 6;
    }
}
