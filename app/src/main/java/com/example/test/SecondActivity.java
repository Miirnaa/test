package com.example.test;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView title,Description;
    String data1 ,data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.myImageView);
        title = findViewById(R.id.title);
        Description = findViewById(R.id.Description);
        getData();


    }

    private void getData(){
        if(getIntent().hasExtra("myImage")&& getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2")){
            data1 =getIntent().getStringExtra("data1");
            data2 =getIntent().getStringExtra("data2");
            myImage =getIntent().getIntExtra("myImage", 1);

        }else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    private   void setData(){
        title.setText(data1);
        Description.setText(data2);
        mainImageView.setImageResource(myImage);

    }
}
