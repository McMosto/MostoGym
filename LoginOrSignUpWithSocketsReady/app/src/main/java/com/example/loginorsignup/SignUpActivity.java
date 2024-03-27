package com.example.loginorsignup;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, nicknameEditText, emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        firstNameEditText = findViewById(R.id.editTextFirstName);
        lastNameEditText = findViewById(R.id.editTextLastName);
        nicknameEditText = findViewById(R.id.editTextNickname);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);

        Button signUpButton = findViewById(R.id.buttonSignUp);
        ImageButton backButton = findViewById(R.id.backButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
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
            new SignUpActivity.SignUpTask().execute();
            Intent welcomeIntent = new Intent(SignUpActivity.this, WelcomeActivity.class);
            startActivity(welcomeIntent);
            finish(); // Optional: finish the SignUpActivity to prevent going back
        } else {
            // Show error message
            Toast.makeText(this, "Invalid sign-up data", Toast.LENGTH_SHORT).show();
        }
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

    private class SignUpTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String nickname = nicknameEditText.getText().toString();
                DataOutputStream out;
                DataInputStream in;
                byte[] data; // Change the type to byte array
                String msg = ""; // create a message
                Socket s = SocketManager.getSocketInstance();
                if (s != null) {
                    try {
                        out = new DataOutputStream(s.getOutputStream());
                        in = new DataInputStream(s.getInputStream());
                        out.writeUTF(String.format("signu-%1$s-%2$s-%3$s-%4$s-%5$s", email, password, firstName, lastName, nickname));
                        Log.d("Client", "Request sent");

                        // Read bytes from the input stream
                        data = new byte[1024];
                        int bytesRead = in.read(data);

                        // Convert bytes to String
                        msg = new String(data, 0, bytesRead, "UTF-8");
                        Log.d("Client", "Response received: " + msg + " Length: " + msg.length());

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("Client", "Error: " + e.getMessage());
                    }

                    if (msg.equals("CONT\r\n")) {
                        // Sign up successful, navigate to WelcomeActivity
                        Intent welcomeIntent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                        startActivity(welcomeIntent);
                        finish(); // Optional: finish the SignUpActivity to prevent going back
                    } else {
                        // Show error message
                        Log.e("Client", msg);
                        //Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }

                    // Close the socket after the operation is done
                    try {
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

