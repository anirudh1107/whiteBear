package com.example.android.whitebear.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.whitebear.Adapters.Customers_adapter;
import com.example.android.whitebear.Models.CustomerModel;
import com.example.android.whitebear.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellpc on 3/17/2018.
 */

public class fragment1 extends Fragment {

    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment1,container,false);
        recyclerView=view.findViewById(R.id.customer_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<CustomerModel> list=new ArrayList<>();
        list.add(new CustomerModel("AB1234","Abhisek Bharti",85659502,"Bokaro","ma_piyu","bharti@gmail.com"));
        list.add(new CustomerModel("SU225","Sumant Kumar",9575862,"Khagariya","ma_sets","iyar@gmail.com"));
        Customers_adapter adapter=new Customers_adapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
