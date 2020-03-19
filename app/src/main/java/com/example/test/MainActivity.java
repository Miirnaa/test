package com.example.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.test.ui.notifications.NotificationsFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button;
    private Button button2,button4,button5,button6,button7,button8,button9;
    private Button button3;
    ViewFlipper v_flipper;
ListView listView;
SearchView searchView;
ArrayList<String> list;
ArrayAdapter<String>adapter;
String[] names={"Fida Pharmacy","Health House Pharmacy","Vanda Phamacy","Aljamea Pharmacy"};
int [] pics={R.drawable.fida,R.drawable.health,R.drawable.vanda,R.drawable.univer};
    public boolean onCreateOptionsMenu(Menu menu) {

      getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.searchview);
    /* SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setQueryHint("Type here To Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
              adapter.getFilter().filter(newText);
                return false;
            }
        });*/
        return true;
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView= findViewById(R.id.lv1);
        searchView = (SearchView) findViewById(R.id.searchView);
        list= new ArrayList<>();
        list.add("Medicines");
        list.add("Hair & Cream treatments");
        list.add("Health Care");
        list.add("Ladies Perfume");
        list.add("Men's Perfume");
        list.add("Mom & Baby");
        listView.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity9();
            }
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        v_flipper = findViewById(R.id.v_flipper);

        int images[] = {R.drawable.pho, R.drawable.images, R.drawable.mer, R.drawable.inv};


        for (int image : images) {
            flipperImages(image);
        }
    }


    public void openActivity2(){
        Intent intent = new Intent(this, jalapharm.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, lahempharm.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, sahourpharm.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, fida.class);
        startActivity(intent);
    } public void openActivity6(){
        Intent intent = new Intent(this, vand.class);
        startActivity(intent);
    } public void openActivity7(){
        Intent intent = new Intent(this, univer.class);
        startActivity(intent);
    } public void openActivity8(){
        Intent intent = new Intent(this, health.class);
        startActivity(intent);
    } public void openActivity9(){
        Intent intent = new Intent(this, sameer.class);
        startActivity(intent);
    }

    public void flipperImages(int image) {

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, act1.class);
                startActivity(intent);

        }
        switch (item.getItemId()) {
            case R.id.item3:
                Intent intent = new Intent(MainActivity.this, settings.class);
                startActivity(intent);
        }

        switch (item.getItemId()) {
            case R.id.item4:
                Intent intent = new Intent(MainActivity.this, share.class);
                startActivity(intent);
        }

        switch (item.getItemId()) {
            case R.id.item6:
                Intent intent = new Intent(MainActivity.this, mylocation.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    }
