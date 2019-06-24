package com.example.frontend;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView tvUsername;
    private String username = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("usernameKey");
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        tvUsername = (TextView)navigationView.getHeaderView(0).findViewById(R.id.tvUsername);
        tvUsername.setText(username);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.nav_collections:
                        menuItem.setChecked(true);
                        displayMessage("Collection selected...");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_pen:
                        menuItem.setChecked(true);
                        displayMessage("Pen selected...");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_models:
                        menuItem.setChecked(true);
                        displayMessage("Models selected...");
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });

    }

    private void displayMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
