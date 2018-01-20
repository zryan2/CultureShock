package com.example.ryan.cultureshock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Countries extends AppCompatActivity {

    Button buttonUSA;


    //default screen when first open app, should change to country chosen as default after
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        buttonUSA = (Button)findViewById(R.id.buttonUSA);

        buttonUSA.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Countries.this, MainActivity.class);
                        startActivity(i);
                    }
                }

        );
    }
}
