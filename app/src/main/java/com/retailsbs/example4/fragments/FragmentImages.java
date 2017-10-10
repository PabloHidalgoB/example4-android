package com.retailsbs.example4.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.retailsbs.example4.R;
import com.retailsbs.example4.activities.MainActivity;
import com.retailsbs.example4.activities.RootActivity;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class FragmentImages extends Fragment {

    private RootActivity mRoot;
    private LinearLayout mLinearLayout;


    private ImageButton mRubberduck;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRoot = ((MainActivity) getActivity());

        mLinearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_images, container, false);

        mRubberduck = (ImageButton) mLinearLayout.findViewById(R.id.btn_rubberduck);

        final MediaPlayer rubberduck = MediaPlayer.create(mRoot, R.raw.duck);
        mRubberduck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rubberduck.start();
            }
        });

        return mLinearLayout;
    }

}
