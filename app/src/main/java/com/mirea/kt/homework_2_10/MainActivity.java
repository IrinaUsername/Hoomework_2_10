package com.mirea.kt.homework_2_10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStart;
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.enterButton){
            Intent intent = new Intent(this,ApplicationActivity.class);
            startActivityForResult(intent,12345);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonStart = findViewById(R.id.enterButton);
        buttonStart.setOnClickListener(this);
    }



}