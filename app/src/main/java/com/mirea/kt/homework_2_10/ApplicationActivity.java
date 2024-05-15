package com.mirea.kt.homework_2_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApplicationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextBrand, editTextNumber, editTextYear;
    Button buttonSave;
    Button buttonContinue;



    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        editTextBrand = findViewById(R.id.editTextBrand);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextYear = findViewById(R.id.editTextYear);
        buttonSave = findViewById(R.id.buttonSave);
        buttonContinue = findViewById(R.id.buttonContinue);


        buttonSave.setOnClickListener(this);
        buttonContinue.setOnClickListener(this);

        this.dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));



    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonSave){
            String brand = editTextBrand.getText().toString();
            String number = editTextNumber.getText().toString();
            String year = editTextYear.getText().toString() ;
            if(!brand.isEmpty() && !number.isEmpty() && !year.isEmpty() ){
                boolean result = dbManager.saveCarToDatabase(new Car(brand,number,Integer.parseInt(year)));
                if(result){
                    Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.buttonContinue) {
            startActivity(new Intent(this, CarActivity.class));

        }
    }


    /*private void saveCarInfo() {
        String brand = editTextBrand.getText().toString();
        String number = editTextNumber.getText().toString();
        int year = Integer.parseInt(editTextYear.getText().toString());

        
    }*/

}