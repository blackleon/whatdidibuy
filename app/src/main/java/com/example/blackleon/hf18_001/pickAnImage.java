package com.example.blackleon.hf18_001;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class pickAnImage extends AppCompatActivity {

    public pickAnImage()
    {

    }

    public static class Item
    {

        public String price;
        public String buydate;

        public Item(String pr, String dt)
        {
            price = pr;
            buydate = dt;
        }
    }

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");


    public String getStringValue(EditText v)
    {
        return v.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_an_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView list = (ListView) findViewById(R.id.list_dynamic);
        Button food = (Button) findViewById(R.id.btnyemek);
        Button bill = (Button) findViewById(R.id.btnfatura);
        Button cloth = (Button) findViewById(R.id.btngiyim);
        Button education = (Button) findViewById(R.id.btnegitim);
        Button health = (Button) findViewById(R.id.btnsaglik);
        Button travel = (Button) findViewById(R.id.btnulasim);
        final EditText valued = (EditText) findViewById(R.id.edittext);



        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child("food").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
                valued.setText("");
            }
        });

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child("bill").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
                valued.setText("");
            }
        });

        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child("cloth").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
                valued.setText("");
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child("education").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
                valued.setText("");
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child("health").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
                valued.setText("");
            }
        });

        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child("travel").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
                valued.setText("");
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "I am WORKING!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pick_an_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
