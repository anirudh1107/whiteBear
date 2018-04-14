package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.whitebear.Models.OurOffers;
import com.example.android.whitebear.R;

import java.util.List;

public class HomeAlbumAdapter extends RecyclerView.Adapter<HomeAlbumAdapter.HomeAlbumViewHolder> {
    private Context context;
    private List<OurOffers> list;
    private LayoutInflater inflater;
    public HomeAlbumAdapter(Context context,List<OurOffers> list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }
    public HomeAlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.home_album_card,parent,false);
        return new HomeAlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeAlbumViewHolder holder, int position) {
        OurOffers current=list.get(position);
        holder.offerName.setText(current.getOfferName());
        holder.offerCount.setText(current.getOfferCount()+"options");
        holder.thumbnail.setImageResource(current.getThumbnail());

        //loading album cover using Glide Library
        Glide.with(context).load(current.getThumbnail()).into(holder.thumbnail);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class HomeAlbumViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView offerName;
        public TextView offerCount;
        public HomeAlbumViewHolder(View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.thumbnail);
            offerName=itemView.findViewById(R.id.offerName);
            offerCount=itemView.findViewById(R.id.offferCount);
        }
    }

}

