package com.retailsbs.example4.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.retailsbs.example4.R;
import com.retailsbs.example4.activities.DetailsActivity;
import com.retailsbs.example4.activities.ListerActivity;
import com.retailsbs.example4.activities.MainActivity;
import com.retailsbs.example4.activities.RootActivity;

import java.util.ArrayList;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class FragmentButtons extends Fragment {

    private RootActivity mRoot;
    private LinearLayout mLinearLayout;

    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Button btn05;
    private Button btn06;
    private Button btn07;
    private Button btn08;

    private ArrayList<Button> mArrayButtons = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRoot = ((MainActivity) getActivity());

        mLinearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_buttons, container, false);

        btn01 = (Button) mLinearLayout.findViewById(R.id.btn_menu_01);
        btn02 = (Button) mLinearLayout.findViewById(R.id.btn_menu_02);
        btn03 = (Button) mLinearLayout.findViewById(R.id.btn_menu_03);
        btn04 = (Button) mLinearLayout.findViewById(R.id.btn_menu_04);
        btn05 = (Button) mLinearLayout.findViewById(R.id.btn_menu_05);
        btn06 = (Button) mLinearLayout.findViewById(R.id.btn_menu_06);
        btn07 = (Button) mLinearLayout.findViewById(R.id.btn_menu_07);
        btn08 = (Button) mLinearLayout.findViewById(R.id.btn_menu_08);

        for (int i = 0; i < mArrayButtons.size(); i++)
            mArrayButtons.get(i).setVisibility(View.GONE);

        mArrayButtons.add(btn01);
        mArrayButtons.add(btn02);
        mArrayButtons.add(btn03);
        mArrayButtons.add(btn04);
        mArrayButtons.add(btn05);
        mArrayButtons.add(btn06);
        mArrayButtons.add(btn07);
        mArrayButtons.add(btn08);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(mRoot, ListerActivity.class);
                startActivity(myIntent);
            }
        });


        return mLinearLayout;
    }


}
