package com.example.test;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RequestQueue mrequestque;
    RecyclerView recyclerView;
    String s1[], s2[];
    int images[]= {R.drawable.ww,R.drawable.rrr, R.drawable.rr,R.drawable.t
            ,R.drawable.tt,R.drawable.s,R.drawable.tt,R.drawable.tt,R.drawable.q, R.drawable.w};
/*ViewFlipper v_flipper;*/
    SearchView searchView;

    private MyAdapter mExampleadapter;
    private ArrayList<MyAdapter> mexamplelist;

    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.menu, menu);
      MenuItem menuItem = menu.findItem(R.id.searchviewmenu);

        searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query)
          {
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
              return false;

          }
      });
return true;


        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        s1 =getResources().getStringArray(R.array.programming_languages);
        s2 =getResources().getStringArray(R.array.Description);
        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


mrequestque = Volley.newRequestQueue(this);
parseJSON();



        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
  /*      v_flipper = findViewById(R.id.v_flipper);

        int images[] = {R.drawable.pho, R.drawable.images, R.drawable.mer, R.drawable.inv};


        for (int image : images) {
            flipperImages(image);
        }
    }*/



   /* public void flipperImages(int image) {

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }*/

    }
    private void parseJSON(){
        String url = "http://www.palpharmacy.com/index.php/getPharmacies";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override

            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("x");
                    for (int i = 0; i< jsonArray.length();i++){
                        JSONObject hit= jsonArray.getJSONObject(i);
                        String name = hit.getString("name_ar");
                        int id = hit.getInt("user_id");
                        mexamplelist.add(new MyAdapter(name,id));
                    }
                    mExampleadapter= new MyAdapter(MainActivity.this,mexamplelist);
                    recyclerView.setAdapter(mExampleadapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mrequestque.add(request);
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
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }

    }



