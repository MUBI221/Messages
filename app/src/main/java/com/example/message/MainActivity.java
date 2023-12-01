package com.example.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.message.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


binding = ActivityMainBinding.inflate (getLayoutInflater ());
setContentView (binding.getRoot ());

binding.edit.setOnClickListener (new View.OnClickListener () {
    @Override
    public void onClick(View view) {
        startActivity (new Intent (MainActivity.this, Dashboard.class));
    }
});

        binding.NewMassage.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent;

                intent = new Intent (MainActivity.this,New_Message.class);
                startActivity (intent);
            }
        });

    }
}