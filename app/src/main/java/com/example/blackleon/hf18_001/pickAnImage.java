package com.example.blackleon.hf18_001;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class pickAnImage extends AppCompatActivity {

    public pickAnImage()
    {

    }

    private ArrayList<String> mMeetings = new ArrayList<>();

    public static class Item
    {

        public String price;
        public String buydate;
        public String type;

        public Item(String price, String buydate, String type)
        {
            this.price = price;
            this.buydate = buydate;
            this.type = type;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getBuydate() {
            return buydate;
        }

        public void setBuydate(String buydate) {
            this.buydate = buydate;
        }

        public Item()
        {

        }
    }

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");
    DatabaseReference ReadmyRef = database.getReference("users/items");


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
        final ListView list = (ListView) findViewById(R.id.list_dynamic);
        Button food = (Button) findViewById(R.id.btnyemek);
        Button bill = (Button) findViewById(R.id.btnfatura);
        Button cloth = (Button) findViewById(R.id.btngiyim);
        Button education = (Button) findViewById(R.id.btnegitim);
        Button health = (Button) findViewById(R.id.btnsaglik);
        Button travel = (Button) findViewById(R.id.btnulasim);
        Button show = (Button) findViewById(R.id.btnshow);
        final EditText valued = (EditText) findViewById(R.id.edittext);

        final ArrayList<Item> array = new ArrayList<>();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array.clear();
                ReadmyRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Item it =ds.getValue(Item.class);
                            array.add(it);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("zsd",databaseError.getMessage());
                    }
                });

            }
        });
        final specialAdapter sA = new specialAdapter(this, array);
        sA.clearArray();
        sA.notifyDataSetChanged();
        Log.e("wtf", Integer.toString(sA.getCount()));
        list.setAdapter(sA);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()),"food"));
                valued.setText("");sA.notifyDataSetChanged();array.clear();
            }
        });

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()),"bill"));
                valued.setText("");sA.notifyDataSetChanged();array.clear();
            }
        });

        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()),"cloth"));
                valued.setText("");sA.notifyDataSetChanged();array.clear();
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()),"education"));
                valued.setText("");sA.notifyDataSetChanged();array.clear();
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()),"health"));
                valued.setText("");sA.notifyDataSetChanged();array.clear();
            }
        });

        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer a = r.nextInt();
                myRef.child("items").child(a.toString()).setValue(new Item(valued.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()), "travel"));
                valued.setText("");sA.notifyDataSetChanged();array.clear();
            }
        });
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
