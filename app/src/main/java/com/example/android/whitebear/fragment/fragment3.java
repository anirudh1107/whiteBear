package com.example.android.whitebear.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.whitebear.Adapters.Feedback_adapter;
import com.example.android.whitebear.FeedbackActivity;
import com.example.android.whitebear.Models.FeedbackModel;
import com.example.android.whitebear.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellpc on 3/17/2018.
 */

public class fragment3 extends Fragment implements Feedback_adapter.ClickListener {

    private RecyclerView feedbackRecycle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment3,container,false);
        feedbackRecycle=view.findViewById(R.id.feedback_recycle);
        feedbackRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        List<FeedbackModel> list=new ArrayList<>();
        list.add(new FeedbackModel("AB1234","ma_piyu"));
        Feedback_adapter adapter=new Feedback_adapter(getContext(),list);
        adapter.setClickListener(this);
        feedbackRecycle.setAdapter(adapter);
        return view;


    }

    @Override
    public void itemClicked(View view, int position) {
        startActivity(new Intent(getActivity(), FeedbackActivity.class));

    }
}
