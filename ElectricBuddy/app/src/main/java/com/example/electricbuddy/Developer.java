package com.example.electricbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.widget.TextView;

public class Developer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        TextView link=findViewById(R.id.LinkText);
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }
}