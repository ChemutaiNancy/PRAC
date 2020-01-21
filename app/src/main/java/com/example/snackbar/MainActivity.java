package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button nButton, aButton, cButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nButton = findViewById(R.id.normal);
        aButton = findViewById(R.id.action);
        cButton = findViewById(R.id.custom);

        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(nButton, "I am normal", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(aButton, "I am action", Snackbar.LENGTH_LONG);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Action Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(cButton, "I am custom", Snackbar.LENGTH_LONG);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Custom Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.setActionTextColor(Color.BLUE);
                View sb = snackbar.getView();
                TextView tv = (TextView)sb.findViewById(R.id.snackbar_text);
                tv.setTextColor(Color.GREEN);
                snackbar.show();
            }
        });
    }
}
