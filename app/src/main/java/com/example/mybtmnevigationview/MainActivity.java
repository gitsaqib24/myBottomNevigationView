package com.example.mybtmnevigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.btmnv);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navhome)
                {
                    loadFragment(new AFragment(),false);

                } else if (id == R.id.navsearch) {
                    loadFragment(new BFragment(),false);
                } else if (id == R.id.navadd) {
                    loadFragment(new CFragment(),false);
                } else if (id == R.id.navcontact) {
                    loadFragment(new DFragment(),false);
                } else { // Profile
                    loadFragment(new EFragment(),false);
                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.navhome); //set default selected item
        //when app open

    }

    public void loadFragment(Fragment fragment,Boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag)
        {
            ft.add(R.id.container,fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();


    }
}