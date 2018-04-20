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
        wedding.add(new CategoryModel(R.drawable.ic_check_circle_black_24dp,"Wedding1"));
        wedding.add(new CategoryModel(R.drawable.ic_face_black_24dp,"Wedding2"));
        wedding.add(new CategoryModel(R.drawable.ic_chevron_right_white_24dp,"wedding3"));

        ArrayList<CategoryModel> Concerts=new ArrayList<>();
        Concerts.add(new CategoryModel(R.drawable.ic_check_circle_black_24dp,"Concerts1"));
        Concerts.add(new CategoryModel(R.drawable.ic_face_black_24dp,"Concerts2"));
        Concerts.add(new CategoryModel(R.drawable.ic_chevron_right_white_24dp,"Concerts3"));

        ArrayList<CategoryModel> CorporateEvents=new ArrayList<>();
        CorporateEvents.add(new CategoryModel(R.drawable.ic_check_circle_black_24dp,"Corporate"));
        CorporateEvents.add(new CategoryModel(R.drawable.ic_face_black_24dp,"Corporate2"));
        CorporateEvents.add(new CategoryModel(R.drawable.ic_chevron_right_white_24dp,"Corporate3"));

        ArrayList<CategoryModel> MultiNationalCuisine=new ArrayList<>();
        MultiNationalCuisine.add(new CategoryModel(R.drawable.ic_check_circle_black_24dp,"Wedding1"));
        MultiNationalCuisine.add(new CategoryModel(R.drawable.ic_face_black_24dp,"Wedding2"));
        MultiNationalCuisine.add(new CategoryModel(R.drawable.ic_chevron_right_white_24dp,"wedding3"));

        ArrayList<CategoryModel> BirthdayCelebration=new ArrayList<>();
        BirthdayCelebration.add(new CategoryModel(R.drawable.ic_check_circle_black_24dp,"Wedding1"));
        BirthdayCelebration.add(new CategoryModel(R.drawable.ic_face_black_24dp,"Wedding2"));
        BirthdayCelebration.add(new CategoryModel(R.drawable.ic_chevron_right_white_24dp,"wedding3"));


        Bundle extra=getIntent().getExtras();
        position=extra.getInt("position");


        arr.add(wedding);
        arr.add(Concerts);
        arr.add(CorporateEvents);
        arr.add(MultiNationalCuisine);
        arr.add(BirthdayCelebration);



        tvName = findViewById(R.id.tv_dev_name);
        tvEmail = findViewById(R.id.tv_dev_email);
        ivImg = findViewById(R.id.iv_dev_img);

        context = this;

        setInitialValue();

        prepareRecyclerView();
    }

    private void setInitialValue() {
        tvName.setText("Abhishek Kumar");
        tvEmail.setText("abhishek1706@hotmail.com");

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
