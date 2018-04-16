package com.example.android.whitebear.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.whitebear.R;

/**
 * Created by dellpc on 3/17/2018.
 */

public class fragment4 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment4,container,false);

        ImageView facebookButton = view.findViewById(R.id.fb);
        facebookButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(browserIntent);

            }
        });
        ImageView instaButton = view.findViewById(R.id.insta);
        instaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com"));
                startActivity(browserIntent);

            }
        });
        ImageView twitterButton = view.findViewById(R.id.twitter);
        twitterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com"));
                startActivity(browserIntent);

            }
        });
        TextView whatsapp = view.findViewById(R.id.whatsapptext);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9800098000"));
                startActivity(callIntent);
            }
        });

        view.findViewById(R.id.textView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmailIntent = new Intent(Intent.ACTION_VIEW);
                gmailIntent.setData(Uri.parse("whitebearEP@nitjsr.ac.in"));


                gmailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");

                startActivity(gmailIntent);

            }

        });

        return view;
    }
}
