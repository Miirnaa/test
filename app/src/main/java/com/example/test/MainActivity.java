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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
ViewFlipper v_flipper;
Button button;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*button = findViewById(R.id.button1);*/
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);  v_flipper=findViewById(R.id.v_flipper);

        int images[]= {R.drawable.frag,R.drawable.images, R.drawable.mer,R.drawable.sales};


        for ( int image : images)
        {
            flipperImages(image);
        }
        TextView textView = findViewById(R.id.text_view);
        String text="We are here to help you find the nearest & opened\n" +
                "Pharmacies, to save your time so you just have to put your Location\n" +
                "Hope You enjoy it ";
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(Color.BLUE);
        ss.setSpan(fcsBlue, 0 , 100, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    public void flipperImages(int image){

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
}
