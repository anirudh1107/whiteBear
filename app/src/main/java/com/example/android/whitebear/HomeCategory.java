package com.example.android.whitebear;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.whitebear.Adapters.DevRVAdapter;
import com.example.android.whitebear.Models.CategoryModel;

import java.util.ArrayList;

public class HomeCategory extends AppCompatActivity implements View.OnClickListener {

    private static TextView tvName, tvDesc, tvEmail;
    private static ImageView ivImg;
    private static int linkedIn, fb, github, whatsApp;
    private static Context context;
    private ArrayList<ArrayList<CategoryModel>> arr;
    private int position;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_category);



        arr=new ArrayList<>();
        ArrayList<CategoryModel> wedding=new ArrayList<>();
        wedding.add(new CategoryModel(R.drawable.beachwedding,"Beach Wedding"));
        wedding.add(new CategoryModel(R.drawable.destination,"Destination Wedding"));
        wedding.add(new CategoryModel(R.drawable.temple,"Temple"));
        wedding.add(new CategoryModel(R.drawable.royalwedding2,"Royal Wedding"));

        ArrayList<CategoryModel> Concerts=new ArrayList<>();
        Concerts.add(new CategoryModel(R.drawable.lagori,"Laghori Band"));
        Concerts.add(new CategoryModel(R.drawable.nucleya,"Nuclea"));
        Concerts.add(new CategoryModel(R.drawable.americanauthors,"American Authors"));
        Concerts.add(new CategoryModel(R.drawable.coldplay,"Coldplay"));
        Concerts.add(new CategoryModel(R.drawable.imaginedragons,"Imagine Dragon"));
        Concerts.add(new CategoryModel(R.drawable.metallica,"Metallica"));

        ArrayList<CategoryModel> CorporateEvents=new ArrayList<>();
        CorporateEvents.add(new CategoryModel(R.drawable.award,"Awards"));
        CorporateEvents.add(new CategoryModel(R.drawable.conference,"Conference"));
        CorporateEvents.add(new CategoryModel(R.drawable.dealersinvestment,"Dealer Investment"));
        CorporateEvents.add(new CategoryModel(R.drawable.fashion,"Fashin"));
        CorporateEvents.add(new CategoryModel(R.drawable.productlaunch,"Product Launch"));

        ArrayList<CategoryModel> PreWedding=new ArrayList<>();
        PreWedding.add(new CategoryModel(R.drawable.bachelor,"Bachelor Party"));
        PreWedding.add(new CategoryModel(R.drawable.engagemet2,"Engagement"));
        PreWedding.add(new CategoryModel(R.drawable.mehendi,"Mehendi"));
        PreWedding.add(new CategoryModel(R.drawable.sngeet,"Sangeet"));


        ArrayList<CategoryModel> IndianCelebrity=new ArrayList<>();
        IndianCelebrity.add(new CategoryModel(R.drawable.celebs,"Indian Celebrity"));



        Bundle extra=getIntent().getExtras();
        position=extra.getInt("position");


        arr.add(wedding);
        arr.add(Concerts);
        arr.add(CorporateEvents);
        arr.add(PreWedding);
        arr.add(IndianCelebrity);



        tvName = findViewById(R.id.tv_dev_name);
        tvEmail = findViewById(R.id.tv_dev_email);
        ivImg = findViewById(R.id.iv_dev_img);

        context = this;

        setInitialValue();

        prepareRecyclerView();
    }

    private void setInitialValue() {

    }

    private void prepareRecyclerView() {
        RecyclerView rv = findViewById(R.id.rv_dev);
        LinearLayoutManager ll = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(ll);
        rv.setHasFixedSize(true);
        rv.setAdapter(new DevRVAdapter(this,arr.get(position)));
    }

    @Override
    public void onClick(View view) {

    }

    public static void setDevData(int image, String name) {

        ivImg.setImageResource(image);
        tvName.setText(name);

    }
}
