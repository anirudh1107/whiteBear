package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.android.whitebear.R;

public class SwipeImageAdapter extends PagerAdapter {
    int[] images = {R.drawable.agra,R.drawable.concert1,R.drawable.food1,R.drawable.bday3};
    private Context context;
    private LayoutInflater layoutInflater;
    public SwipeImageAdapter(Context context){
        this.context=context;

    }

    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(FrameLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.home_swipe_layout,container,false);
        ImageView swipeImage=itemView.findViewById(R.id.swipe_image);
        swipeImage.setImageResource(images[position]);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((FrameLayout)object);
    }
}
