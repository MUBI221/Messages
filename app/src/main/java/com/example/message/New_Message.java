package com.example.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class New_Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_new_message);

        View Cancel;
        Cancel = findViewById (R.id.Cancel);
        Cancel.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent;

                intent = new Intent (New_Message.this, MainActivity.class);
                startActivity (intent);
            }
        });

    }
}