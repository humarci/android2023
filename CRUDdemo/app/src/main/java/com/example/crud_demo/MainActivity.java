package com.example.crud_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.crud_demo.helper.DatabaseHelper;
import com.example.crud_demo.model.BoardGame;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    private Button crt_btn;
    private ListView listViewOfGame;
    private TextView calculateRevenue;

    ArrayAdapter gameArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        crt_btn= findViewById(R.id.createProduct);
        listViewOfGame=findViewById(R.id.listViewGames);
        calculateRevenue=findViewById(R.id.revenueNum);

        calculateRevenue.setText(String.valueOf("MISSING"));

        gameArrayAdapter = new ArrayAdapter<BoardGame>(MainActivity.this,
                android.R.layout.simple_list_item_1, databaseHelper.getAllGame());
        listViewOfGame.setAdapter(gameArrayAdapter);

        // Action for create button
        crt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // openCreateProductPage();
            }
        });
    }



}