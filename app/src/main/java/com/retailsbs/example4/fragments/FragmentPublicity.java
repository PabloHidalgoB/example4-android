package com.retailsbs.example4.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.retailsbs.example4.R;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class FragmentPublicity extends Fragment {

    private LinearLayout mLinearLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mLinearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_publicity, container, false);

        return mLinearLayout;
    }
}
