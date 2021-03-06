package com.example.easycoding;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
private Toolbar toolbar;
private int category_index;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.prog_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.prog);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category",category_index);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.prog);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.id_prog)
        {
            toolbar.setTitle(R.string.prog);
            array = getResources().getStringArray(R.array.prog_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 0;
        }
        else if(id == R.id.id_do)
        {
            toolbar.setTitle(R.string.dost);
            array = getResources().getStringArray(R.array.do_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 1;
        }
        else if(id == R.id.id_game)
        {
            toolbar.setTitle(R.string.dop);
            array = getResources().getStringArray(R.array.game_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 2;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}