package com.love.lec03demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double price=79.99;
    int noOfTickets;
    double total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView im = findViewById(R.id.imageView);
        final Spinner sp = findViewById(R.id.spinner);
        final EditText tickets = findViewById(R.id.editText);
        final Button calculate = findViewById(R.id.button);

       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final int index = sp.getSelectedItemPosition();
                if(index == 0){
                    im.setImageResource(R.drawable.concert);
                }
                else if(index == 1){
                    im.setImageResource(R.drawable.ferry);
                }
                else if(index == 2){
                    im.setImageResource(R.drawable.triathalon);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
       calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               noOfTickets = Integer.parseInt(tickets.getText().toString());
               total = noOfTickets * price;
               Toast.makeText(getApplicationContext(),Double.toString(total),Toast.LENGTH_SHORT).show();
           }
       });
    }
}
