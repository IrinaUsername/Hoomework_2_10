package com.mirea.kt.homework_2_10;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarActivity extends AppCompatActivity {


    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));
        setContentView(R.layout.activity_car);

        ArrayList<Car> cars = this.dbManager.loadAllCarsFromDatabase();
        Log.d("ertyuiop",cars.get(0).toString());
        RecyclerView rcView = findViewById(R.id.recycler);
        CarAdapter adapter = new CarAdapter(cars);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rcView.setAdapter(adapter);




    }
}