package com.retailsbs.example4.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.retailsbs.example4.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Trabajo on 10-10-2017.
 */

public class FragmentListTitle extends Fragment {

    private LinearLayout mLayout;
    private String mTitle, mDescription;
    private TextView mTxtTitle, mTxtDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mLayout = (LinearLayout) inflater.inflate(R.layout.fragment_list_title, container, false);

        mTxtTitle = (TextView) mLayout.findViewById(R.id.txt_title);
        mTxtDescription = (TextView) mLayout.findViewById(R.id.txt_description);

        mTitle = "Welcome to lister";
        mDescription = "this lister is a lister that list lists";

        mTxtTitle.setText(mTitle);
        mTxtDescription.setText(mDescription);

        return mLayout;
    }

    public String getDataLister(){

        String mData;
        JSONObject mJSONObject = new JSONObject();

        try {
            mData = "{\"data\":{\"title\":\"" + mTitle + "\",\"description\":\"" + mDescription + "\"}}";

            mJSONObject = new JSONObject(mData);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return mJSONObject.toString();
    }
}
