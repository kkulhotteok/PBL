package com.test.pbl;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private DrawerLayout drawerLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment,new homefragment()).commit();
                    break;
                case R.id.bottom_decibel:
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment,new decibelfragment()).commit();
                    break;
                case R.id.bottom_clearly:
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment,new clearlyfragment()).commit();
                    break;
                case R.id.bottom_mypage:
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment,new mypagefragment()).commit();
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout = (DrawerLayout) findViewById(R.id.main_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        mTextMessage = (TextView) findViewById(R.id.message);


        //BottomNavigationView
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottombar navigation option
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        //Side bar NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.right_side);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.menu_alram){
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment,new alramfragment()).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }
}
