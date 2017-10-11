package com.retailsbs.example4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.retailsbs.example4.R;
import com.retailsbs.example4.fragments.FragmentList;
import com.retailsbs.example4.fragments.FragmentListTitle;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Trabajo on 06-10-2017.
 */

public class ListerActivity extends RootActivity {

    private FragmentList mFragmentList;
    private FragmentListTitle mFragmentListTitle;

    //Toolbar elements and buttons
    private Toolbar toolbar;
    private LinearLayout mLayoutBack, mLayoutHome;
    private TextView mTitleToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTitleToolbar = (TextView) toolbar.findViewById(R.id.txt_toolbar_title);
        mTitleToolbar.setText("Lister Activity");

        mLayoutBack = (LinearLayout) toolbar.findViewById(R.id.layout_toolbar_back);
        mLayoutHome = (LinearLayout) toolbar.findViewById(R.id.layout_toolbar_home);

        mFragmentListTitle = new FragmentListTitle();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_listerTitle, mFragmentListTitle, null).commit();


        mFragmentList = new FragmentList();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_list,mFragmentList, null).commit();

        mLayoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag","BUTTON BACK CLICK");
                finish();
            }
        });

        mLayoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag","BUTTON HOME CLICK");
                Intent intent = new Intent(ListerActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }

    public JSONObject getDataLister(){

        mFragmentListTitle.getDataLister();
        //se obtienen loa datos de la persona que estan guardados dentro de mFragmentPerson a travez de un JSONObject.tostring
        JSONObject mJSONObject = new JSONObject();
        try{
            mJSONObject =  new JSONObject(mFragmentListTitle.getDataLister());
        }catch(JSONException e){
            e.printStackTrace();
        }
        return mJSONObject;
    }
}
