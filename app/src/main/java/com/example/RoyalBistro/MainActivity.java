package com.example.RoyalBistro;

import android.content.Intent;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int count_pasta=0;
    static int count_burger=0;
    static int count_fries=0;
    static int count_milkshake=0;
    static int count_moctail=0;
    static int count_monstershake=0;
    static int count_pizza=0;
    static int count_sandwich=0;
    static int count_wrap=0;

    static int new_value;

    static TextView viewsum;
    static int sum=0;

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());
        viewPager=(ViewPager)findViewById(R.id.container);
        setUpViewPager(viewPager);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        BottomAppBar bar=(BottomAppBar)findViewById(R.id.bar);
        setSupportActionBar(bar);

        viewsum=(TextView)findViewById(R.id.view_total);

    }

    public void setUpViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter=new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new pasta_fragment(),"pasta");
        adapter.addFragment(new sandwich_fragment(),"sandwich");
        adapter.addFragment(new wraps(),"wraps");
        adapter.addFragment(new fries_fragment(),"Fries");
        adapter.addFragment(new burgers_fragment(),"Burgers");
        adapter.addFragment(new pizza(),"pizza");
        adapter.addFragment(new moctail(),"moctail");
        adapter.addFragment(new milkshake(),"milkshake");
        adapter.addFragment(new monstershake(),"monstershake");

        viewPager.setAdapter(adapter);
    }

    public void show_order_summary(View view){
        Intent intent = new Intent(this,order_summary.class);
        startActivity(intent);
    }


}
