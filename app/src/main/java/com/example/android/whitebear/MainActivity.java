package com.example.android.whitebear;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.example.android.whitebear.fragment.fragment1;
import com.example.android.whitebear.fragment.fragment3;
import com.example.android.whitebear.fragment.fragment4;
import com.example.android.whitebear.fragment.frragment2;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private FrameLayout mainFrame;
    private FragmentManager manager;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.main_bottomnav);
        navigationView.setOnNavigationItemSelectedListener(mItemSelected);

        manager=getFragmentManager();
        android.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.main_frame,new fragment1());
        transaction.commit();


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mItemSelected=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if(item.getItemId()==R.id.bottom_cust)
            {
                replace(new fragment1());
            }
            else if(item.getItemId()==R.id.bottom_shedule)
            {
                replace(new frragment2());
            }
            else if(item.getItemId()==R.id.bottom_feedback)
            {
                replace(new fragment3());
            }
            else if(item.getItemId()==R.id.bottom_contact)
            {
                replace(new fragment4());
            }

            return true;
        }
    };

    private void replace(Fragment f)
    {
        android.app.FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame,f);
        transaction.commit();
    }
}
