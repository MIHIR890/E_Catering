package com.example.annapurna;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {
    Button confirmbutton;
    ImageView next;
    ImageView cross;
    TextView tv4;
    Button fooddetails;
    Button cartbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        confirmbutton = findViewById(R.id.confirmbutton);
        next = findViewById(R.id.next);
        cross = findViewById(R.id.cross);
        fooddetails = findViewById(R.id.fooddetails);
        cartbutton = findViewById(R.id.cartbutton);
        tv4 = findViewById(R.id.tv4);

        Intent intent = getIntent();
        String receivedValue = intent.getStringExtra("KEY_SENDER");
        tv4.setText(receivedValue);



        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FourthActivity.this);
                builder.setTitle("ORDER CONFIRMATION");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.greentick);
                builder.setMessage("ARE YOU SURE YOU WANT TO PLACE AN ORDER ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(FourthActivity.this);
                        builder.setTitle("THANK YOU");
                        builder.setMessage("ORDER HAS BEEN PLACED");
                        builder.setIcon(R.drawable.greentick);
                        builder.show();

                    }

                });


                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(FourthActivity.this);
                        builder.setTitle("CANCELLATION");

                        builder.setMessage("ORDER HAS BEEN CANCELLED");
                        builder.setIcon(R.drawable.greentick);
                        builder.show();

                    }


                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();



            }
        });
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FourthActivity.this, SecondActivity.class);
                startActivity(intent1);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(FourthActivity.this,FifthActivity.class);
                intent2.putExtra("KEY_SENDER",tv4.getText().toString());
                startActivity(intent2);
            }
        });
        cartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this, CartActivity.class);
                intent.putExtra("PASSENGER_NAME",tv4.getText().toString());
                intent.putExtra("FOOD_NAME",fooddetails.getText().toString());

                startActivity(intent);

            }
        });


    }

}