package com.example.android.whitebear.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.whitebear.Adapters.HomeAlbumAdapter;
import com.example.android.whitebear.Adapters.SwipeImageAdapter;
import com.example.android.whitebear.Models.OurOffers;
import com.example.android.whitebear.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class fragment0 extends android.app.Fragment {
    @Nullable
    private ViewPager imageViewPager;
    private SwipeImageAdapter adapter;
    private CircleIndicator circleIndicator;
    private static int currentPage;
    private RecyclerView albumRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment0, container, false);
        //code for sliding image view pager
        imageViewPager = view.findViewById(R.id.image_view_pager);
        adapter = new SwipeImageAdapter(getContext());
        imageViewPager.setAdapter(adapter);
        circleIndicator = view.findViewById(R.id.circleIndicator);
        circleIndicator.setViewPager(imageViewPager);

        //code for Recycler view as grid album
        List<OurOffers> list=new ArrayList<>();
        list.add(new OurOffers("Wedding",7,R.drawable.agra));
        list.add(new OurOffers("Concerts",5,R.drawable.concert1));
        list.add(new OurOffers("Corporate Events",10,R.drawable.bday1));
        list.add(new OurOffers("Multi National Cuisine",14,R.drawable.food1));
        list.add(new OurOffers("Birthday Celebrations",10,R.drawable.cake2));
        albumRecyclerView=view.findViewById(R.id.home_album_recycler_view);
        albumRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        albumRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        albumRecyclerView.setItemAnimator(new DefaultItemAnimator());
        HomeAlbumAdapter adapter=new HomeAlbumAdapter(getContext(),list);
        albumRecyclerView.setAdapter(adapter);








        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                imageViewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
        return view;
    }


    //recycler view item decoration
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}

