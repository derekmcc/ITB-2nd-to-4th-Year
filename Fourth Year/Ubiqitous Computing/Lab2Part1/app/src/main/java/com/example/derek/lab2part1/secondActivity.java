package com.example.derek.lab2part1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name = getIntent().getExtras().getString("Message");

        String toastMessage = "Thank you " + name + ", Your request is being processed";

        TextView t = findViewById(R.id.txtUpdate);
        t.setText(toastMessage);
    }
}
