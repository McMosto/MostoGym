package com.example.loginorsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RoutinesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);
        ImageButton backButton = findViewById(R.id.backButton);
        Button FBButton = findViewById(R.id.FBButton);
        Button ULButton = findViewById(R.id.ULButton);
        Button PPLButton = findViewById(R.id.PPLButton);
        Button ASButton = findViewById(R.id.ASButton);
        Button NEButton = findViewById(R.id.NEButton);
        Button BSButton = findViewById(R.id.BSButton);
        ImageButton CloseTextButton = findViewById(R.id.CloseTextButton);
        TextView FBText = findViewById(R.id.FBText);
        TextView ULText = findViewById(R.id.ULText);
        TextView PPLText = findViewById(R.id.PPLText);
        TextView ASText = findViewById(R.id.ASText);
        TextView NEText = findViewById(R.id.NEText);
        TextView BSText = findViewById(R.id.BSText);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(RoutinesActivity.this, WorkoutActivity.class);
                startActivity(backIntent);
                finish();
            }
        });

        FBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FBText.setVisibility(View.VISIBLE);
                CloseTextButton.setVisibility(View.VISIBLE);
                FBButton.setVisibility(View.INVISIBLE);
            }
        });

        ULButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ULText.setVisibility(View.VISIBLE);
                CloseTextButton.setVisibility(View.VISIBLE);
                ULButton.setVisibility(View.INVISIBLE);
            }
        });

        PPLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PPLText.setVisibility(View.VISIBLE);
                CloseTextButton.setVisibility(View.VISIBLE);
                PPLButton.setVisibility(View.INVISIBLE);
            }
        });

        ASButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ASText.setVisibility(View.VISIBLE);
                CloseTextButton.setVisibility(View.VISIBLE);
                ASButton.setVisibility(View.INVISIBLE);
            }
        });

        NEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NEText.setVisibility(View.VISIBLE);
                CloseTextButton.setVisibility(View.VISIBLE);
                NEButton.setVisibility(View.INVISIBLE);
            }
        });

        BSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BSText.setVisibility(View.VISIBLE);
                CloseTextButton.setVisibility(View.VISIBLE);
                BSButton.setVisibility(View.INVISIBLE);
            }
        });

        CloseTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FBText.setVisibility(View.INVISIBLE);
                ULText.setVisibility(View.INVISIBLE);
                PPLText.setVisibility(View.INVISIBLE);
                ASText.setVisibility(View.INVISIBLE);
                NEText.setVisibility(View.INVISIBLE);
                BSText.setVisibility(View.INVISIBLE);
                CloseTextButton.setVisibility(View.INVISIBLE);
                FBButton.setVisibility(View.VISIBLE);
                ULButton.setVisibility(View.VISIBLE);
                PPLButton.setVisibility(View.VISIBLE);
                ASButton.setVisibility(View.VISIBLE);
                NEButton.setVisibility(View.VISIBLE);
                BSButton.setVisibility(View.VISIBLE);
            }
        });

    }
}
